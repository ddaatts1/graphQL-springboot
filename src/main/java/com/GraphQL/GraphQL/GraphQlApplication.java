package com.GraphQL.GraphQL;

import com.GraphQL.GraphQL.Repository.MongoRepository;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GraphQlApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(GraphQlApplication.class, args);


		MongoRepository mongoRepository = context.getBean(MongoRepository.class);

		 List<Document> list = mongoRepository.getAllAddress();

		System.out.println("===========>");
		 list.forEach(l-> System.out.println(l));

	}

}
