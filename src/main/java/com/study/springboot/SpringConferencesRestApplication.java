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

/*Question: how to use myproperties in services?
Answer:
* We recommend that @ConfigurationProperties only deal with the environment and, in particular,
* does not inject other beans from the context. For corner cases, setter injection can be used or
* any of the *Aware interfaces provided by the framework (such as EnvironmentAware if you need access to the Environment).
* If you still want to inject other beans using the constructor, the configuration properties bean must
* be annotated with @Component and use JavaBean-based property binding.*/
public class SpringConferencesRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConferencesRestApplication.class, args);
	}

}
