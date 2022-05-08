package com.mousa.bmdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mousa.bmdemo.dto.PlotDto;
import com.mousa.bmdemo.payload.ListResponse;
import com.mousa.bmdemo.serviceimpl.PlotServiceImpl;

@RestController
@RequestMapping("${api.prefix.irrigation}" + "/plot")
public class PlotController {
	@Autowired 
	PlotServiceImpl plotServiceImpl;
	
	@GetMapping
	public ListResponse<PlotDto> getAllPlots(@RequestParam(defaultValue = "1000 L") String amountOfWater){

		
		if(!amountOfWater.equals("50 L")) {
			return plotServiceImpl.getAll();
		}else {
			return plotServiceImpl.getAlertNotification(amountOfWater);


		}
		
	}
	
	@PostMapping
	public PlotDto savePlot(@RequestBody PlotDto plotDto) {
		return plotServiceImpl.save(plotDto);
	}
	@GetMapping("/{id}")
	public PlotDto getPlotById(@PathVariable(value = "id") Long id) {
		return plotServiceImpl.getById(id);
	}
	@DeleteMapping("/{id}")
	public void deletePlotById(@PathVariable(value = "id") Long id) {
		plotServiceImpl.delete(id);
	}
	
	@PatchMapping("/{id}")
	public PlotDto updatePlot( @RequestBody PlotDto plotDto, @PathVariable(value = "id") Long id) throws Exception {
		return plotServiceImpl.update(plotDto, id);
	}


}
