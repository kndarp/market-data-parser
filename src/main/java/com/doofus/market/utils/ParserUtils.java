package com.doofus.market.utils;

import org.apache.commons.io.FilenameUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParserUtils {
  public static final DateFormat INPUT_FORMAT = new SimpleDateFormat("ddMMyy");
  public static final DateFormat OUTPUT_FORMAT = new SimpleDateFormat("yyyyMMdd");

  public static String getDateForRecords(String filePath) {
    try {
      return OUTPUT_FORMAT.format(INPUT_FORMAT.parse(extractFileName(filePath).substring(2)));
    } catch (ParseException e) {
      throw new RuntimeException(
          "Error parsing date from document name. Please check document name.", e);
    }
  }

  public static String extractDir(String filePath) {
    return FilenameUtils.getFullPath(filePath);
  }

  public static String extractFileName(String filePath) {
    return FilenameUtils.getBaseName(filePath);
  }
}
