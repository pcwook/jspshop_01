package com.example.jpashop01.jpashop01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Jpashop01Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Jpashop01Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Jpashop01Application.class);
    }

}
