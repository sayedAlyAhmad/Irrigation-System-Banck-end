package com.mousa.bmdemo.config;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {
	@Bean
	@Profile("db")
	public DataSource getTestingDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
 		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3306/irrigation");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		return dataSourceBuilder.build();
	}

}
