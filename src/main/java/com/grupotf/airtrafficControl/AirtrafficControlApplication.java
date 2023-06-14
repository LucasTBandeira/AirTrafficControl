package com.grupotf.airtrafficControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.grupotf" })
@EntityScan(basePackages = { "com.grupotf" })
@EnableJpaRepositories(basePackages =  {"com.grupotf"})
public class AirtrafficControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirtrafficControlApplication.class, args);
	}
}
