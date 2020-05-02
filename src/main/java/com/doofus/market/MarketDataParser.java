package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import com.doofus.market.utils.ParserUtils;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/** Hello world! */
public class MarketDataParser {
  public static void main(String[] args)
      throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

    final String filePath = args[0];

    BseDataParser bseDataParser = new BseDataParser();
    final List<BseInputRecord> bseInputRecords = bseDataParser.read(Paths.get(filePath));
    final List<BseOutputRecord> bseOutputRecords = bseDataParser.convert(bseInputRecords);
    bseOutputRecords.forEach(
        bseOutputRecord -> bseOutputRecord.setDate(ParserUtils.getDateForRecords(filePath)));

    System.out.println(bseDataParser.write(bseOutputRecords));
  }
}
