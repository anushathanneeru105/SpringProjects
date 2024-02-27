package com.appsbyanusha.linkedinlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;

@SpringBootApplication(exclude = MongoDataAutoConfiguration.class)
public class ReactiveAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveAppApplication.class, args);
	}

}
