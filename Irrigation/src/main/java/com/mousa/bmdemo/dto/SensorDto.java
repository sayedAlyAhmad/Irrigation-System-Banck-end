package com.mousa.bmdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorDto {
	private Long id;
	private String name;
	private boolean alert;
//	private PlotDto plot;

}
