package com.doofus.market;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DataParser<T, O> {
    List<T> read(Path path) throws IOException;

    List<O> convert(List<T> records);

    Path write(List<O> records);
}
