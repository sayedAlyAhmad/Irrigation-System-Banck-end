package com.mousa.bmdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mousa.bmdemo.dto.SensorDto;
import com.mousa.bmdemo.payload.ListResponse;
import com.mousa.bmdemo.serviceimpl.SensorServiceImpl;

@RestController
@RequestMapping("${api.prefix.irrigation}" + "/sensor")
public class SensorController {
	
	
	@Autowired 
	SensorServiceImpl sensorServiceImpl;
	
	@GetMapping
	public ListResponse<SensorDto> getAllSensors(){
		return sensorServiceImpl.getAll();
	}
	
	@PostMapping
	public SensorDto saveSensor(@RequestBody SensorDto sensorDto) {
		return sensorServiceImpl.save(sensorDto);
	}
	@GetMapping("/{id}")
	public SensorDto getSensorById(@PathVariable(value = "id") Long id) {
		return sensorServiceImpl.getById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteSensorById(@PathVariable(value = "id") Long id) {
		sensorServiceImpl.delete(id);
	}
	
	@PatchMapping("/{id}")
	public SensorDto updateSensor( @RequestBody SensorDto sensorDto, @PathVariable(value = "id") Long id) throws Exception {
		return sensorServiceImpl.update(sensorDto, id);
	}


}
