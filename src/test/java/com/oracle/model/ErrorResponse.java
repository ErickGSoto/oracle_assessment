package com.oracle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
  List<ErrorDetail> detail;

  public List<ErrorDetail> getDetail() {
    return detail;
  }

  public ErrorResponse setDetail(List<ErrorDetail> detail) {
    this.detail = detail;
    return this;
  }
}
