package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan({"com.example.springboot,"
		+ "com.example.springboot.model"})
public class MethodValidationConfig {

	@Bean
	public MethodValidationPostProcessor methodValidationInterceptor() {
		return new MethodValidationPostProcessor();
	}
}
