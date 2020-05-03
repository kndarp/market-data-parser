package com.doofus.market.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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

  public static List<String> unzip(String filePath) throws IOException {
    // TODO extract
    // TODO return file paths
    final List<String> extractedFilePaths = new ArrayList<>();
    final String directory = extractDir(filePath);
    final ZipFile zipFile = new ZipFile(filePath);
    final Enumeration<? extends ZipEntry> entries = zipFile.entries();
    while (entries.hasMoreElements()) {
      ZipEntry zipEntry = entries.nextElement();
      String destPath = directory + zipEntry.getName();
      if (!isValidDestPath(directory, destPath)) {
        throw new IOException("Final directory output path is invalid: " + destPath);
      }
      if (zipEntry.isDirectory()) {
        new File(destPath).mkdirs();
      } else {
        try (InputStream inputStream = zipFile.getInputStream(zipEntry);
            FileOutputStream outputStream = new FileOutputStream(destPath)) {
          int data = inputStream.read();
          while (data != -1) {
            outputStream.write(data);
            data = inputStream.read();
          }
        }
        extractedFilePaths.add(destPath);
      }
    }

    return extractedFilePaths;
  }

  public static String extractDir(String filePath) {
    return FilenameUtils.getFullPath(filePath);
  }

  public static String extractFileName(String filePath) {
    return FilenameUtils.getBaseName(filePath);
  }

  private static boolean isValidDestPath(String targetDir, String destPathStr) {
    Path destPath = Paths.get(destPathStr);
    Path destPathNormalized = destPath.normalize();
    return destPathNormalized.toString().startsWith(targetDir);
  }

  public static void delete(String filePath) {
    FileUtils.deleteQuietly(new File(filePath));
  }
}
