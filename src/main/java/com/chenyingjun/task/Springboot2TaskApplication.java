package com.chenyingjun.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = { "classpath:applicationContext*.xml" })
public class Springboot2TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2TaskApplication.class, args);
	}
}
