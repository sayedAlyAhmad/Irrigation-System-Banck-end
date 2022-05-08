package com.mousa.bmdemo.service;

import com.mousa.bmdemo.dto.PlotDto;
import com.mousa.bmdemo.payload.ListResponse;

public interface PlotService {
	
	ListResponse<PlotDto> getAll();
	PlotDto getById(Long id);
	ListResponse<PlotDto> getAlertNotification(String amountOfWater);

	PlotDto save(PlotDto plotDto);
	void delete(Long id);
	PlotDto update(PlotDto plotDto, Long id) throws Exception;

}
