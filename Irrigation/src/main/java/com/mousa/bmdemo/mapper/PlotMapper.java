package com.mousa.bmdemo.mapper;

import com.mousa.bmdemo.dto.PlotDto;
import com.mousa.bmdemo.entities.PlotDemo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface PlotMapper extends BasicMapper<PlotDemo, PlotDto> {
	
	
	@Override
	@Mapping(source = "sensor.id", target = "sensorID")
	PlotDto entityToDto(PlotDemo entity);

}
