-- first table plot
CREATE TABLE `plot_demo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AMOUNT_OF_WATER` varchar(45) DEFAULT NULL,
  `TIME` varchar(45) DEFAULT NULL,
  `SENSOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SENSOR_DEMO_FK_idx` (`SENSOR_ID`),
  CONSTRAINT `SENSOR_DEMO_FK` FOREIGN KEY (`SENSOR_ID`) REFERENCES `sensor_demo` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- second table sensor_demo
CREATE TABLE `sensor_demo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


-- instruction to create TABLES
-- DB type mysql
-- please run the second script firstly
-- and the end script last

