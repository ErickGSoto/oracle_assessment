package com.oracle.model.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oracle.model.APIV2Response;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasurementResponse extends APIV2Response {
  public static final String JSON_SCHEMA_PATH = "schemas/Measurement.json";
  private List<Measurement> results = new ArrayList<>();

  public List<Measurement> getResults() {
    return results;
  }

  public MeasurementResponse setResults(
      List<Measurement> results) {
    this.results = results;
    return this;
  }
}
