package com.hashtag.techtalk.graphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.hashtag.techtalk.graphqlexample")
public class GraphqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlExampleApplication.class, args);
	}

}
