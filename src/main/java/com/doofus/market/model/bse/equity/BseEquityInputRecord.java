package com.doofus.market.model.bse.equity;

import com.doofus.market.model.CSVRecord;
import com.opencsv.bean.CsvBindByName;

public class BseEquityInputRecord implements CSVRecord {

  // SC_CODE,SC_NAME,SC_GROUP,SC_TYPE,OPEN,HIGH,LOW,CLOSE,LAST,PREVCLOSE,NO_TRADES,NO_OF_SHRS,NET_TURNOV,TDCLOINDI

  @CsvBindByName(column = "SC_CODE")
  private int scCode;

  @CsvBindByName(column = "SC_NAME")
  private String scName;

  @CsvBindByName(column = "SC_GROUP")
  private String scGroup;

  @CsvBindByName(column = "SC_TYPE")
  private String scType;

  @CsvBindByName(column = "OPEN")
  private float open;

  @CsvBindByName(column = "HIGH")
  private float high;

  @CsvBindByName(column = "LOW")
  private float low;

  @CsvBindByName(column = "CLOSE")
  private float close;

  @CsvBindByName(column = "LAST")
  private float last;

  @CsvBindByName(column = "PREVCLOSE")
  private float prevClose;

  @CsvBindByName(column = "NO_TRADES")
  private long noTrades;

  @CsvBindByName(column = "NO_OF_SHRS")
  private long noOfShares;

  @CsvBindByName(column = "NET_TURNOV")
  private float netTurnov;

  @CsvBindByName(column = "TDCLOINDI")
  private String tdCloIndi;

  public int getScCode() {
    return scCode;
  }

  public void setScCode(int scCode) {
    this.scCode = scCode;
  }

  public String getScName() {
    return scName;
  }

  public void setScName(String scName) {
    this.scName = scName.trim();
  }

  public String getScGroup() {
    return scGroup;
  }

  public void setScGroup(String scGroup) {
    this.scGroup = scGroup;
  }

  public String getScType() {
    return scType;
  }

  public void setScType(String scType) {
    this.scType = scType;
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

  public float getLast() {
    return last;
  }

  public void setLast(float last) {
    this.last = last;
  }

  public float getPrevClose() {
    return prevClose;
  }

  public void setPrevClose(float prevClose) {
    this.prevClose = prevClose;
  }

  public long getNoTrades() {
    return noTrades;
  }

  public void setNoTrades(long noTrades) {
    this.noTrades = noTrades;
  }

  public long getNoOfShares() {
    return noOfShares;
  }

  public void setNoOfShares(long noOfShares) {
    this.noOfShares = noOfShares;
  }

  public float getNetTurnov() {
    return netTurnov;
  }

  public void setNetTurnov(float netTurnov) {
    this.netTurnov = netTurnov;
  }

  public String getTdCloIndi() {
    return tdCloIndi;
  }

  public void setTdCloIndi(String tdCloIndi) {
    this.tdCloIndi = tdCloIndi;
  }

  @Override
  public String toString() {
    return com.google.common.base.MoreObjects.toStringHelper(this)
        .add("scCode", scCode)
        .add("scName", scName)
        .add("scGroup", scGroup)
        .add("scType", scType)
        .add("open", open)
        .add("high", high)
        .add("low", low)
        .add("close", close)
        .add("last", last)
        .add("prevClose", prevClose)
        .add("noTrades", noTrades)
        .add("noOfShares", noOfShares)
        .add("netTurnov", netTurnov)
        .add("tdCloIndi", tdCloIndi)
        .toString();
  }
}
