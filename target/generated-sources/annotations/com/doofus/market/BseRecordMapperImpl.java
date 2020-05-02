package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-02T14:54:20+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class BseRecordMapperImpl implements BseRecordMapper {

    @Override
    public BseOutputRecord bseInputToOutputRecord(BseInputRecord bseInputRecord) {
        if ( bseInputRecord == null ) {
            return null;
        }

        BseOutputRecord bseOutputRecord = new BseOutputRecord();

        bseOutputRecord.setVolume( (long) bseInputRecord.getNetTurnov() );
        bseOutputRecord.setTicker( bseInputRecord.getScName() );
        bseOutputRecord.setOi( bseInputRecord.getNoOfShares() );
        bseOutputRecord.setOpen( bseInputRecord.getOpen() );
        bseOutputRecord.setHigh( bseInputRecord.getHigh() );
        bseOutputRecord.setLow( bseInputRecord.getLow() );
        bseOutputRecord.setClose( bseInputRecord.getClose() );

        return bseOutputRecord;
    }
}
