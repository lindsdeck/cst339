package com.gcu.dedeck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.gcu"})
@EntityScan("com.gcu.data.entity")
@EnableJpaRepositories("com.gcu.data.repository")
public class DedeckApplication {

    public static void main(String[] args) {
        SpringApplication.run(DedeckApplication.class, args);
    }
}