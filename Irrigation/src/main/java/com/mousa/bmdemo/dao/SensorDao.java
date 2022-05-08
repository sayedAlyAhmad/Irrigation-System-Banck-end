package com.mousa.bmdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mousa.bmdemo.entities.SensorDemo;

public interface SensorDao extends JpaRepository<SensorDemo, Long>{


}
