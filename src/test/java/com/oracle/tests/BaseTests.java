package com.oracle.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTests {

  protected final RequestSpecification requestSpec = new RequestSpecBuilder()
      .setContentType(ContentType.JSON)
      .addFilter(new ResponseLoggingFilter())
      .addFilter(new RequestLoggingFilter())
      .addFilter(new AllureRestAssured()).build();

  public BaseTests(String baseUri, String basePath) {
    requestSpec.basePath(basePath).baseUri(baseUri);
  }
}
