package com.doofus.market;

import com.doofus.market.model.BseInputRecord;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class MarketDataParser
{
    public static void main( String[] args ) throws IOException {
        BseDataParser bseDataParser = new BseDataParser();
        final List<BseInputRecord> bseInputRecords = bseDataParser.read(Paths.get("/Users/kndarpp/kndarp/files/EQ300420.CSV"));
        bseInputRecords.forEach(System.out::println);
    }
}
