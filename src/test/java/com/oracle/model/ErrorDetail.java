package com.oracle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetail {

  private List<String> loc = new ArrayList<>();
  private String msg;
  private String type;

  public List<String> getLoc() {
    return loc;
  }

  public ErrorDetail setLoc(List<String> loc) {
    this.loc = loc;
    return this;
  }

  public String getMsg() {
    return msg;
  }

  public ErrorDetail setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  public String getType() {
    return type;
  }

  public ErrorDetail setType(String type) {
    this.type = type;
    return this;
  }
}
