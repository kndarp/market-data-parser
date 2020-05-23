package com.doofus.market;

import com.doofus.market.model.bse.equity.BseEquityInputRecord;
import com.doofus.market.model.bse.equity.BseEquityOutputRecord;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class BseDataParser implements DataParser<BseEquityInputRecord, BseEquityOutputRecord> {
  @Override
  public List<BseEquityInputRecord> read(Path path) {

    try (Reader reader = Files.newBufferedReader(path)) {
      return new CsvToBeanBuilder<BseEquityInputRecord>(reader)
          .withType(BseEquityInputRecord.class)
          .build()
          .parse();
    } catch (IOException e) {
      throw new RuntimeException("Exception in read()", e);
    }
  }

  @Override
  public List<BseEquityInputRecord> read(InputStream inputStream) {

    try (Reader reader = new InputStreamReader(inputStream)) {
      return new CsvToBeanBuilder<BseEquityInputRecord>(reader)
          .withType(BseEquityInputRecord.class)
          .build()
          .parse();
    } catch (IOException e) {
      throw new RuntimeException("Exception in read()", e);
    }
  }

  @Override
  public List<BseEquityOutputRecord> convert(List<BseEquityInputRecord> records) {
    return records.stream()
        .map(BseRecordMapper.INSTANCE::bseInputToOutputRecord)
        .collect(Collectors.toList());
  }

  @Override
  public byte[] write(List<BseEquityOutputRecord> records, Writer writer) {
    try {
      MarketOutputMappingStrategy<BseEquityOutputRecord> marketOutputMappingStrategy =
          new MarketOutputMappingStrategy<>();
      marketOutputMappingStrategy.setType(BseEquityOutputRecord.class);

      StatefulBeanToCsv<BseEquityOutputRecord> statefulBeanToCsv =
          new StatefulBeanToCsvBuilder<BseEquityOutputRecord>(writer)
              .withMappingStrategy(marketOutputMappingStrategy)
              .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
              .withApplyQuotesToAll(false)
              .build();
      statefulBeanToCsv.write(records);
      return writer.toString().getBytes(StandardCharsets.UTF_8);
    } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
      throw new RuntimeException("Exception in write()", e);
    }
  }
}
