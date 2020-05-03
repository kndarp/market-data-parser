package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import com.doofus.market.utils.ParserUtils;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.doofus.market.utils.ParserUtils.unzip;

/** Hello world! */
public class MarketDataParser {
  public static void main(String[] args) throws IOException {

    final String zipPath = args[0];
    BseDataParser bseDataParser = new BseDataParser();
    unzip(zipPath)
        .forEach(
            filePath -> {
              try {
                final List<BseInputRecord> bseInputRecords =
                    bseDataParser.read(new FileInputStream(filePath));

                final List<BseOutputRecord> bseOutputRecords =
                    bseDataParser.convert(bseInputRecords);
                bseOutputRecords.forEach(
                    bseOutputRecord ->
                        bseOutputRecord.setDate(ParserUtils.getDateForRecords(filePath)));

                System.out.println(bseDataParser.write(bseOutputRecords));
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              }
            });
  }
}
