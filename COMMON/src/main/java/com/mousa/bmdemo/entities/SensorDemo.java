package com.mousa.bmdemo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
@Data   // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "sensor_demo")

public class SensorDemo implements Serializable{
	
	   private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private Long id;
	    @Column(name = "NAME")
	    private String name;
	    @OneToOne(mappedBy = "sensor")
	    private PlotDemo plot;

}
