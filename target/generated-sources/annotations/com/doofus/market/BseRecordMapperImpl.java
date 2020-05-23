package com.doofus.market;

import com.doofus.market.model.bse.equity.BseEquityInputRecord;
import com.doofus.market.model.bse.equity.BseEquityOutputRecord;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-22T20:20:13+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
*/
public class BseRecordMapperImpl implements BseRecordMapper {

    @Override
    public BseEquityOutputRecord bseInputToOutputRecord(BseEquityInputRecord bseEquityInputRecord) {
        if ( bseEquityInputRecord == null ) {
            return null;
        }

        BseEquityOutputRecord bseEquityOutputRecord = new BseEquityOutputRecord();

        bseEquityOutputRecord.setVolume( (long) bseEquityInputRecord.getNetTurnov() );
        bseEquityOutputRecord.setTicker( bseEquityInputRecord.getScName() );
        bseEquityOutputRecord.setOi( bseEquityInputRecord.getNoOfShares() );
        bseEquityOutputRecord.setOpen( bseEquityInputRecord.getOpen() );
        bseEquityOutputRecord.setHigh( bseEquityInputRecord.getHigh() );
        bseEquityOutputRecord.setLow( bseEquityInputRecord.getLow() );
        bseEquityOutputRecord.setClose( bseEquityInputRecord.getClose() );

        return bseEquityOutputRecord;
    }
}
