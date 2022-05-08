package com.mousa.bmdemo.entities;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
@Data   // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "plot_demo")
public class PlotDemo  implements Serializable{
	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private Long id;
	    @Column(name = "AMOUNT_OF_WATER")
	    private String amountOfWater;
	    @Column(name = "TIME")
	    private String time;
	    @JoinColumn(name = "SENSOR_ID", referencedColumnName = "ID")
	    @OneToOne(cascade = CascadeType.ALL)
	    private SensorDemo sensor;

}
