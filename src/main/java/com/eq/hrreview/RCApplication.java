package com.eq.hrreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.eq.hrreview"})
@SpringBootApplication
public class RCApplication {

	public static void main(String[] args) {
		SpringApplication.run(RCApplication.class, args);
	}

}
