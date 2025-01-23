package com.example.spring_boot_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterceptorApplication.class, args);
		System.out.println("Servidor en ejecución...");
	}

}
