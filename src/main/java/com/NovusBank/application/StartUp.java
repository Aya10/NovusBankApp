package com.NovusBank.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.NovusBank.web.WebController;


@SpringBootApplication
@ComponentScan(basePackageClasses=WebController.class)
public class StartUp {
	
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}

}
