package com.doofus.market;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DataParser<T, O> {
  List<T> read(Path path) throws IOException;

  List<O> convert(List<T> records);

  String write(List<O> records)
      throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}
