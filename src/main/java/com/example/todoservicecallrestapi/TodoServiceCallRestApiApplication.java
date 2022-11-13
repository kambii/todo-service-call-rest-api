package com.example.todoservicecallrestapi;

import com.example.todoservicecallrestapi.model.Todo;
import com.example.todoservicecallrestapi.repository.TodoRepository;
import com.example.todoservicecallrestapi.service.JsonPlaceholderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TodoServiceCallRestApiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TodoServiceCallRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TodoServiceCallRestApiApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, TodoRepository repository){
        return args -> {
          // when the application loads get the 200 todos from json placeholder
            List<Todo> todos = jsonPlaceholderService.getTodos();
            // once we have the todos persist them to the db
            repository.saveAll(todos);
            LOG.info("Saved {} todos in the database",todos.size());

            // push this information to our dashboard service

        };
    }
}
