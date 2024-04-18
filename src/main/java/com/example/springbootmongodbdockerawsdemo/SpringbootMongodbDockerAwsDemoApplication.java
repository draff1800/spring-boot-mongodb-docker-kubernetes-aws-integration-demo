package com.example.springbootmongodbdockerawsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringbootMongodbDockerAwsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerAwsDemoApplication.class, args);
	}
}
