package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.study")
@ConfigurationPropertiesScan("com.study.springboot.config")
//@EnableConfigurationProperties(ConferenceSettings.class)
/*To use constructor binding the class must be enabled using @EnableConfigurationProperties
or configuration property scanning. You cannot use constructor binding with beans
that are created by the regular Spring mechanisms (e.g. @Component beans,
beans created via @Bean methods or beans loaded using @Import)*/
public class SpringConferencesRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConferencesRestApplication.class, args);
	}

}
