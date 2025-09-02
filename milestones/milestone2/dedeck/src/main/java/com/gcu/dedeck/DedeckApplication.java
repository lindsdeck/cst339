package com.gcu.dedeck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.gcu"})
public class DedeckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DedeckApplication.class, args);
	}

}
