package com.mousa.bmdemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mousa.bmdemo.dao.PlotDao;
import com.mousa.bmdemo.dao.SensorDao;
import com.mousa.bmdemo.dto.PlotDto;
import com.mousa.bmdemo.entities.PlotDemo;
import com.mousa.bmdemo.entities.SensorDemo;
import com.mousa.bmdemo.exception.NotFoundException;
import com.mousa.bmdemo.mapper.PlotMapper;
import com.mousa.bmdemo.mapper.SensorMapper;
import com.mousa.bmdemo.payload.ListResponse;
import com.mousa.bmdemo.service.PlotService;

@Service
public class PlotServiceImpl implements PlotService {

	@Autowired
	PlotMapper plotMapper;
	@Autowired
	PlotDao plotDao;
	@Autowired
	SensorDao sensorDao;
	@Autowired
	SensorMapper sensorMapper;

	@Override
	public ListResponse<PlotDto> getAll() {
		return new ListResponse<>(plotMapper.listToDto(plotDao.findAll()));
	}

 
	@Override
	public PlotDto getById(Long id) {
		return plotMapper
				.entityToDto(plotDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "plot-01")));
	}
	
	@Override
	public ListResponse<PlotDto> getAlertNotification(String amountOfWater) {
		String lower= "500 L";
		String upper ="10000000 L";
		if(amountOfWater.compareTo(lower)> 0 && upper.compareTo(amountOfWater)<0) {
			throw new NotFoundException("amount of water should be increased", "water-01");
 		}
		return null;
//		return new ListResponse<>(plotMapper.listToDto(plotDao.findByAmountOfWater(amountOfWater)));
 		}

	@Override
	public PlotDto save(PlotDto plotDto) {
		PlotDemo plot = plotMapper.dtoToEntity(plotDto);
		SensorDemo sensorDemo = sensorDao.findById(plotDto.getSensorID())
				.orElseThrow(() -> new NotFoundException("no sensor found", "sensor-01"));

		if (plotDao.findFirstBySensor(sensorDemo).isPresent()) {
			throw new NotFoundException("no sensor avaliable", "s-02");
		}
		plot.setSensor(sensorDemo);
		plot = plotDao.save(plot);
		return plotMapper.entityToDto(plot);
	}

	@Override
	public void delete(Long id) {
		plotDao.deleteById(id);
	}

	@Override
	public PlotDto update(PlotDto plotDto, Long id) throws Exception {
		PlotDemo plot = plotDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "plot-01"));
		plotMapper.updateEntityFromDto(plotDto, plot);
		SensorDemo sensorDemo = sensorDao.findById(plotDto.getSensorID())
				.orElseThrow(() -> new NotFoundException("no sensor found", "sensor-01"));
 		plot.setSensor(sensorDemo);
		plot = plotDao.save(plot);
		return plotMapper.entityToDto(plot);
	}


	



}
