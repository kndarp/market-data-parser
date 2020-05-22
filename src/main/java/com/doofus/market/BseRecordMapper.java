package com.doofus.market;

import com.doofus.market.model.bse.equity.BseEquityInputRecord;
import com.doofus.market.model.bse.equity.BseEquityOutputRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BseRecordMapper {

  BseRecordMapper INSTANCE = Mappers.getMapper(BseRecordMapper.class);

  @Mappings({
    @Mapping(source = "scName", target = "ticker"),
    @Mapping(source = "netTurnov", target = "volume"),
    @Mapping(source = "noOfShares", target = "oi")
  })
  BseEquityOutputRecord bseInputToOutputRecord(BseEquityInputRecord bseEquityInputRecord);
}
