package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.study")
public class SpringConferencesRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConferencesRestApplication.class, args);
	}

}
