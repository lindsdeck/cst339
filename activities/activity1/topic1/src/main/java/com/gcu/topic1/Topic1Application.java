package com.gcu.topic1;

import javax.swing.Spring;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@ComponentScans({ "com.gcu" })

public class Topic1Application {

	public static void main(String[] args) {
		

		System.out.println("Hello, World from my Spring Boot Application.");
		SpringApplication.run(Topic1Application.class, args);

	}

}
