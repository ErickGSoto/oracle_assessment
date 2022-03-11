package com.oracle.model.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Measurement implements Serializable {
  private Integer locationId;
  private String location;
  private String parameter;
  private Float value;
  private MeasurementDate date;
  private String unit;
  private Coordinates coordinates;
  private String country;
  private String city;
  private Boolean isMobile;
  private Boolean isAnalysis;
  private String entity;
  private String sensorType;

  public Integer getLocationId() {
    return locationId;
  }

  public Measurement setLocationId(Integer locationId) {
    this.locationId = locationId;
    return this;
  }

  public String getLocation() {
    return location;
  }

  public Measurement setLocation(String location) {
    this.location = location;
    return this;
  }

  public String getParameter() {
    return parameter;
  }

  public Measurement setParameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

  public Float getValue() {
    return value;
  }

  public Measurement setValue(Float value) {
    this.value = value;
    return this;
  }

  public MeasurementDate getDate() {
    return date;
  }

  public Measurement setDate(MeasurementDate date) {
    this.date = date;
    return this;
  }

  public String getUnit() {
    return unit;
  }

  public Measurement setUnit(String unit) {
    this.unit = unit;
    return this;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Measurement setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public Measurement setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Measurement setCity(String city) {
    this.city = city;
    return this;
  }

  public Boolean getIsMobile() {
    return isMobile;
  }

  public Measurement setIsMobile(Boolean mobile) {
    isMobile = mobile;
    return this;
  }

  public Boolean getIsAnalysis() {
    return isAnalysis;
  }

  public Measurement setIsAnalysis(Boolean analysis) {
    isAnalysis = analysis;
    return this;
  }

  public String getEntity() {
    return entity;
  }

  public Measurement setEntity(String entity) {
    this.entity = entity;
    return this;
  }

  public String getSensorType() {
    return sensorType;
  }

  public Measurement setSensorType(String sensorType) {
    this.sensorType = sensorType;
    return this;
  }
}
