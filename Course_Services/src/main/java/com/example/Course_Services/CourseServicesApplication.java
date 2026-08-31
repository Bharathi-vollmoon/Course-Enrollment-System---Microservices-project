package com.example.Course_Services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourseServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServicesApplication.class, args);
	}

}
