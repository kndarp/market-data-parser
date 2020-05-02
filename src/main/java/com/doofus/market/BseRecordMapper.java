package com.doofus.market;

import com.doofus.market.model.BseInputRecord;
import com.doofus.market.model.BseOutputRecord;
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
  BseOutputRecord bseInputToOutputRecord(BseInputRecord bseInputRecord);
}
