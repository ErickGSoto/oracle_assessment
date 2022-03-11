package com.oracle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
  private String name;
  private String licence;
  private String website;
  private Integer page;
  private Integer limit;
  private Integer found;

  public String getName() {
    return name;
  }

  public Meta setName(String name) {
    this.name = name;
    return this;
  }

  public String getLicence() {
    return licence;
  }

  public Meta setLicence(String licence) {
    this.licence = licence;
    return this;
  }

  public String getWebsite() {
    return website;
  }

  public Meta setWebsite(String website) {
    this.website = website;
    return this;
  }

  public Integer getPage() {
    return page;
  }

  public Meta setPage(Integer page) {
    this.page = page;
    return this;
  }

  public Integer getLimit() {
    return limit;
  }

  public Meta setLimit(Integer limit) {
    this.limit = limit;
    return this;
  }

  public Integer getFound() {
    return found;
  }

  public Meta setFound(Integer found) {
    this.found = found;
    return this;
  }
}
