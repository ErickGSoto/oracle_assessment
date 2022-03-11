package com.oracle.tests;

import static com.oracle.constants.Params.CITY;
import static com.oracle.constants.Params.COUNTRY_ID;
import static com.oracle.constants.Params.DATE_FROM;
import static com.oracle.constants.Params.DATE_TO;
import static com.oracle.constants.Params.LIMIT;
import static com.oracle.constants.Params.ORDER_BY;
import static com.oracle.constants.Params.PAGE;
import static com.oracle.constants.Params.SORT;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

import com.oracle.model.ErrorResponse;
import com.oracle.model.measurement.MeasurementResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class MeasurementsTests extends BaseTests {


  public MeasurementsTests() {
    super("https://docs.openaq.org/", "v2/measurements/");
    requestSpec
        .queryParam(DATE_FROM, "2022-03-09")
        .queryParams(DATE_TO, "2022-03-10");
  }

  // Validate the API properly validates input data structure and returns appropriate HTTP responses when requests are not structured correctly.
  @Test
  public void validateCorrectInputDataStructureAndReturnsHttp200() {
    given()
        .spec(requestSpec)
        .when()
        .queryParam(LIMIT, 10)
        .queryParams(PAGE, 1)
        .queryParams(COUNTRY_ID, "MX")
        .get()
        .then()
        .statusCode(HttpStatus.SC_OK);
  }

  @Test
  public void validateIncorrectInputDataStructureAndReturnsHttp422() {
    given()
        .spec(requestSpec)
        .when()
        .queryParam(LIMIT, "THIS_SHOULD_BE_INTEGER")
        .get()
        .then()
        .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
  }

  // Validate the API constraints.  Some good examples: the “Page” or “Limit” query values should not exceed predefined thresholds and should return a specific error when they do so.
  @Test
  public void validateCountryIdConstraintReturnsHttp422AndErrorMessage() {
    ErrorResponse retrievedError = given()
        .spec(requestSpec)
        .when()
        .queryParam(LIMIT, 10)
        .queryParams(PAGE, 1)
        .queryParam(COUNTRY_ID, "MXX")
        .get()
        .then()
        .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY).extract().as(ErrorResponse.class);

    assertThat(retrievedError.getDetail()).asList().isNotEmpty();
    assertThat(retrievedError.getDetail().get(0).getLoc().get(1)).isEqualTo(COUNTRY_ID);
    assertThat(retrievedError.getDetail().get(0).getMsg()).isEqualTo(
        "ensure this value has at most 2 characters");
  }

  // Validate that the structure of the JSON object matches expectations (“meta”, “results” array, measurement entity object, etc.)
  @Test
  public void validateResponseSchemaMatches() {
    given().spec(requestSpec)
        .when()
        .queryParam(LIMIT, 5).queryParams(PAGE, 1).queryParam(COUNTRY_ID, "MX").get()
        .then()
        .assertThat().body(matchesJsonSchemaInClasspath(MeasurementResponse.JSON_SCHEMA_PATH));
  }

  // Validate that a specific JSON node in the “results” array matches an expectation.
  @Test
  public void getResultsAndValidatesSorting() {
    MeasurementResponse measurementResponse =
        given().spec(requestSpec)
            .when()
            .queryParam(LIMIT, 10).queryParam(PAGE, 1).queryParam(COUNTRY_ID, "MX")
            .queryParam(CITY, "GUANAJUATNO", "BAJA CALIFORNIA NORTE", "JALISCO")
            .queryParam(ORDER_BY, "city")
            .queryParam(SORT, "asc")
            .get()
            .then()
            .statusCode(HttpStatus.SC_OK).extract().as(MeasurementResponse.class);

    assertThat(measurementResponse.getResults()).asList().isNotEmpty();
    assertThat(measurementResponse.getResults().get(0).getCity()).isEqualTo(
        "BAJA CALIFORNIA NORTE");
  }
}
