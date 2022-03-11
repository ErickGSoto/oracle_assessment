package com.oracle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIV2Response {
  private Meta meta;

  public Meta getMeta() {
    return meta;
  }

  public APIV2Response setMeta(Meta meta) {
    this.meta = meta;
    return this;
  }
}
