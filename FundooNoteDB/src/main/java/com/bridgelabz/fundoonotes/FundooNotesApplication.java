package com.bridgelabz.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableCaching
@EnableSwagger2
@ComponentScan(basePackages= {"com.bridgelabz.fundoonotes.configuration.AwsConfig,com.bridgelabz.fundoonotes.service"})

public class FundooNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooNotesApplication.class, args);
	}

}
