package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/** Hello world! */
public class MarketDataParser {
  public static void main(String[] args)
      throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

    BseDataParser bseDataParser = new BseDataParser();
    final List<BseInputRecord> bseInputRecords =
        bseDataParser.read(Paths.get("/Users/kndarpp/kndarp/files/EQ300420.CSV"));
    final List<BseOutputRecord> bseOutputRecords = bseDataParser.convert(bseInputRecords);
    bseOutputRecords.forEach(bseOutputRecord -> bseOutputRecord.setDate("20190430"));

    System.out.println(bseDataParser.write(bseOutputRecords));
  }
}
