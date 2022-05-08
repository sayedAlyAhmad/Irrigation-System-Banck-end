package com.mousa.bmdemo.service;

import com.mousa.bmdemo.dto.SensorDto;
import com.mousa.bmdemo.payload.ListResponse;

public interface SensorService {
	
	ListResponse<SensorDto> getAll();

	SensorDto getById(Long id);
	SensorDto save(SensorDto sensorDto);
	void delete(Long id);
	SensorDto update(SensorDto sensorDto, Long id) throws Exception;

}
