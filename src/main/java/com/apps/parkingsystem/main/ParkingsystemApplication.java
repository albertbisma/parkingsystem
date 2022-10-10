package com.apps.parkingsystem.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.apps.parkingsystem"})
@EnableAutoConfiguration
@EnableJpaRepositories("com.apps.parkingsystem.repository")
@EnableTransactionManagement
@ComponentScan("com.apps.parkingsystem")
@EntityScan(basePackages = "com.apps.parkingsystem.entity")
@EnableSwagger2
public class ParkingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingsystemApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}

}
