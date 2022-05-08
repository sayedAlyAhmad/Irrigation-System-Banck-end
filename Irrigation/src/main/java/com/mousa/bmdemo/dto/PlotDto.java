package com.mousa.bmdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(value = Include.NON_DEFAULT)
public class PlotDto {
	private Long id;
	private String amountOfWater;
	private String time;
	private Long sensorID;


}
