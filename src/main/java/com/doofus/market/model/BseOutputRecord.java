package com.doofus.market.model;

import com.opencsv.bean.CsvBindByName;

public class BseOutputRecord implements CSVRecord {

  // <ticker>,<date>,<open>,<high>,<low>,<close>,<volume>,<o/i>

  @CsvBindByName(column = "<ticker>")
  private String ticker;

  @CsvBindByName(column = "<date>")
  private String date;

  @CsvBindByName(column = "<open>")
  private float open;

  @CsvBindByName(column = "<high>")
  private float high;

  @CsvBindByName(column = "<low>")
  private float low;

  @CsvBindByName(column = "<close>")
  private float close;

  @CsvBindByName(column = "<volume>")
  private long volume;

  @CsvBindByName(column = "<o/i>")
  private long oi;

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public float getOpen() {
    return open;
  }

  public void setOpen(float open) {
    this.open = open;
  }

  public float getHigh() {
    return high;
  }

  public void setHigh(float high) {
    this.high = high;
  }

  public float getLow() {
    return low;
  }

  public void setLow(float low) {
    this.low = low;
  }

  public float getClose() {
    return close;
  }

  public void setClose(float close) {
    this.close = close;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public long getOi() {
    return oi;
  }

  public void setOi(long oi) {
    this.oi = oi;
  }

  @Override
  public String toString() {
    return com.google.common.base.MoreObjects.toStringHelper(this)
        .add("ticker", ticker)
        .add("date", date)
        .add("open", open)
        .add("high", high)
        .add("low", low)
        .add("close", close)
        .add("volume", volume)
        .add("oi", oi)
        .toString();
  }
}
