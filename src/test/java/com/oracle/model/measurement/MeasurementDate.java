package com.oracle.model.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasurementDate {
  private Date utc;
  private Date local;

  public Date getUtc() {
    return utc;
  }

  public MeasurementDate setUtc(Date utc) {
    this.utc = utc;
    return this;
  }

  public Date getLocal() {
    return local;
  }

  public MeasurementDate setLocal(Date local) {
    this.local = local;
    return this;
  }
}
