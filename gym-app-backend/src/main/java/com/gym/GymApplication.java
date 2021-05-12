package com.gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GymApplication extends SpringBootServletInitializer {

	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
	return application.sources(GymApplication.class);  
	}  
	
	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}

}
