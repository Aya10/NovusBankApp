package com.NovusBank.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.NovusBank.web.WebController;


@SpringBootApplication
@ComponentScan(basePackageClasses=WebController.class)
public class StartUp extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartUp.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}

}
