package com.suntek.vehicle.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Applaction {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Applaction.class, args);
	}
}
