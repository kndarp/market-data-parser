package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BseDataParser implements DataParser<BseInputRecord, BseOutputRecord> {
  @Override
  public List<BseInputRecord> read(Path path) throws IOException {

    try (Reader reader = Files.newBufferedReader(path)) {

      CsvToBean<BseInputRecord> cb =
          new CsvToBeanBuilder<BseInputRecord>(reader).withType(BseInputRecord.class).build();

      return cb.parse();
    }
  }

  @Override
  public List convert(List records) {
    return null;
  }

  @Override
  public Path write(List records) {
    return null;
  }
}
