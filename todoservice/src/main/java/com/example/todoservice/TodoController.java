package com.example.todoservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/todos")
    public Todo addTodos(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PatchMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo update){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if( optionalTodo.isEmpty()) throw new TodoNotFoundException();
        Todo todo = optionalTodo.get();
        todo.setTitle(update.getTitle());
        todo.setContent(update.getContent());
        todo.setDone(update.getDone());
        return todoRepository.save(todo);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/todos/{id}")
    public boolean deleteTodo(@PathVariable Long id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if( optionalTodo.isEmpty()) throw new TodoNotFoundException();
        Todo todo = optionalTodo.get();
        todoRepository.delete(todo);
        return true;
    }

}
