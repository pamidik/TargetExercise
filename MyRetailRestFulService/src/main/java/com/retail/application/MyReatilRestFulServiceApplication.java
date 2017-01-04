package com.retail.application;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.retail"})
public class MyReatilRestFulServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyReatilRestFulServiceApplication.class, args);
	}
	
	@Bean(name="dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/TargetExercise");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
	
	@Bean(name="jTemplate")
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name="restTemplate")
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
