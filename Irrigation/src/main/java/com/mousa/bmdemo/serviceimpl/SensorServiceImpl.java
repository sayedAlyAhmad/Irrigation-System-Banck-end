package com.mousa.bmdemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mousa.bmdemo.dao.PlotDao;
import com.mousa.bmdemo.dao.SensorDao;
import com.mousa.bmdemo.dto.SensorDto;
import com.mousa.bmdemo.entities.SensorDemo;
import com.mousa.bmdemo.exception.NotFoundException;
import com.mousa.bmdemo.mapper.SensorMapper;
import com.mousa.bmdemo.payload.ListResponse;
import com.mousa.bmdemo.service.SensorService;

@Service
public class SensorServiceImpl implements SensorService {
	@Autowired
	SensorMapper sensorMapper;
	@Autowired
	SensorDao SensorDao;
	@Autowired
	PlotDao plotDao;

	@Override
	public ListResponse<SensorDto> getAll() {
		return new ListResponse<>(sensorMapper.listToDto(SensorDao.findAll()));
	}
	


	@Override
	public SensorDto getById(Long id) {
		return sensorMapper.entityToDto(SensorDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "sensor-01")));

	}

	@Override
	public SensorDto save(SensorDto sensorDto) {
		SensorDemo sensor=sensorMapper.dtoToEntity(sensorDto);
		sensor = SensorDao.save(sensor);
		return sensorMapper.entityToDto(sensor);
	}

	@Override
	public void delete(Long id) {
		SensorDao.deleteById(id);	
	}

	@Override
	public SensorDto update(SensorDto sensorDto, Long id) throws Exception {
		SensorDemo sensor=SensorDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "sensor-01"));
		sensorMapper.updateEntityFromDto(sensorDto, sensor);
		sensor = SensorDao.save(sensor);
		return sensorMapper.entityToDto(sensor);
	}



}
