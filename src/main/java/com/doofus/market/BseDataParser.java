package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class BseDataParser implements DataParser<BseInputRecord, BseOutputRecord> {
  @Override
  public List<BseInputRecord> read(Path path) throws IOException {

    try (Reader reader = Files.newBufferedReader(path)) {
      return new CsvToBeanBuilder<BseInputRecord>(reader)
          .withType(BseInputRecord.class)
          .build()
          .parse();
    }
  }

  @Override
  public List<BseOutputRecord> convert(List<BseInputRecord> records) {
    return records.stream()
        .map(BseRecordMapper.INSTANCE::bseInputToOutputRecord)
        .collect(Collectors.toList());
  }

  @Override
  public String write(List<BseOutputRecord> records)
      throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
    try (Writer writer = new StringWriter()) {
      MarketOutputMappingStategy<BseOutputRecord> marketOutputMappingStategy =
          new MarketOutputMappingStategy<>();
      marketOutputMappingStategy.setType(BseOutputRecord.class);

      StatefulBeanToCsv<BseOutputRecord> statefulBeanToCsv =
          new StatefulBeanToCsvBuilder<BseOutputRecord>(writer)
              .withMappingStrategy(marketOutputMappingStategy)
              .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
              .withApplyQuotesToAll(false)
              .build();
      statefulBeanToCsv.write(records);
      return writer.toString();
    }
  }
}
