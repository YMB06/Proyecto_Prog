package com.yr.alquilercoches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yr.alquilercoches")
public class AlquilercochesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquilercochesApplication.class, args);
	}

}
