package com.mousa.bmdemo.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.mousa.bmdemo.dto.SensorDto;
import com.mousa.bmdemo.entities.SensorDemo;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface SensorMapper extends BasicMapper<SensorDemo, SensorDto> {

}
