package com.doofus.market;

import com.doofus.market.model.bse.equity.BseEquityInputRecord;
import com.doofus.market.model.bse.equity.BseEquityOutputRecord;

import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public interface DataParser<T, O> {
  List<BseEquityInputRecord> read(InputStream inputStream);

  List<BseEquityInputRecord> read(Path path);

  List<O> convert(List<T> records);

  byte[] write(List<BseEquityOutputRecord> records, Writer writer);
}
