package com.doofus.market;

import com.doofus.market.model.BseInputRecord;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

public interface DataParser<T, O> {
  List<BseInputRecord> read(InputStream inputStream);

  List<BseInputRecord> read(Path path);

  List<O> convert(List<T> records);

  String write(List<O> records);
}
