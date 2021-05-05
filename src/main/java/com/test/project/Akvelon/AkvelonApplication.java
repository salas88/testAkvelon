package com.test.project.Akvelon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AkvelonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkvelonApplication.class, args);
	}

}
