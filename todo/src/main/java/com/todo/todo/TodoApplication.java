package com.todo.todo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Configuration
@EnableJpaAuditing
@EnableAsync
public class TodoApplication {
	public static void main(String[] args) {
		run(TodoApplication.class, args);
	}

}
