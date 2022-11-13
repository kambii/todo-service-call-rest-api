package com.example.todoservicecallrestapi.repository;


import com.example.todoservicecallrestapi.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
