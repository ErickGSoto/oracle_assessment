package com.oracle.model.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

  private Number latitude;
  private Number longitude;

  public Coordinates setLatitude(Number latitude) {
    this.latitude = latitude;
    return this;
  }

  public Coordinates setLongitude(Number longitude) {
    this.longitude = longitude;
    return this;
  }
}
