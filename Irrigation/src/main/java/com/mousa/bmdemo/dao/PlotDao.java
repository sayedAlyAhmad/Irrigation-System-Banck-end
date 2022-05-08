package com.mousa.bmdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mousa.bmdemo.entities.PlotDemo;
import com.mousa.bmdemo.entities.SensorDemo;

import java.util.List;
import java.util.Optional;

public interface PlotDao extends JpaRepository<PlotDemo, Long>{
	                    
	Optional<PlotDemo> findFirstBySensor(SensorDemo sensorDemo);
//	                     amountOfWater
	List<PlotDemo> findByAmountOfWater(String amountofwater);

 

}
