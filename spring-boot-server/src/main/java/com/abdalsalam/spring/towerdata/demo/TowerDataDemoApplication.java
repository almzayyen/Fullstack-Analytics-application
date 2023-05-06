package com.abdalsalam.spring.towerdata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration
public class TowerDataDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TowerDataDemoApplication.class, args);
	}

}
