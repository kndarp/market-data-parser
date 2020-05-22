package com.doofus.market;

import com.doofus.market.model.bse.equity.BseEquityInputRecord;
import com.doofus.market.model.bse.equity.BseEquityOutputRecord;
import com.doofus.market.utils.ParserUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** Hello world! */
public class MarketDataParser {
  public static void main(String[] args) throws IOException {

    final String folderPath = args[0];
    BseDataParser bseDataParser = new BseDataParser();
    Files.walk(Paths.get(folderPath))
        .filter(fp -> FilenameUtils.getExtension(fp.toString()).equalsIgnoreCase("csv"))
        .forEach(
            filePath -> {
              System.out.println("Converting " + filePath);
              String filePathString = filePath.toString();
              try {
                final List<BseEquityInputRecord> bseEquityInputRecords =
                    bseDataParser.read(filePath);

                final List<BseEquityOutputRecord> bseEquityOutputRecords =
                    bseDataParser.convert(bseEquityInputRecords);
                bseEquityOutputRecords.forEach(
                    bseOutputRecord ->
                        bseOutputRecord.setDate(
                            ParserUtils.getDateForRecords(
                                ParserUtils.extractFileName(filePath.toString()))));

                try (Writer writer =
                    new FileWriter(
                        ParserUtils.extractDir(filePathString)
                            + ParserUtils.extractFileName(filePathString)
                            + ".txt")) {

                  System.out.println("Writing txt");
                  bseDataParser.write(bseEquityOutputRecords, writer);
                }

                deleteIfFile(filePathString);
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
  }

  public static void deleteIfFile(String path) {
    File csvFile = new File(path);
    if (!csvFile.isDirectory()) {
      FileUtils.deleteQuietly(csvFile);
      System.out.println("Deleting " + path);
    }
  }
}
