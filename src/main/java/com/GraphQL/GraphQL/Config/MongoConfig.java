package com.GraphQL.GraphQL.Config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/OrderUp");
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

}
