package com.example.todoservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    
}
