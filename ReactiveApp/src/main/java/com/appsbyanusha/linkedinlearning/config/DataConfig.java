package com.appsbyanusha.linkedinlearning.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

import com.mongodb.reactivestreams.client.MongoClient;


@Configuration
@Profile(value="local")
@Import(MongoAutoConfiguration.class)
public class DataConfig {
	public static final String DATABASE_NAME="reservations";
	
	@Bean
	public ReactiveMongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient) {
		return new SimpleReactiveMongoDatabaseFactory(mongoClient, DATABASE_NAME);
		
	}
	
	public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory reactiveMongoDBFactory) {
		return new ReactiveMongoTemplate(reactiveMongoDBFactory);
	}
}
