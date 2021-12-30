
package com.example.todoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "No such Todo")
public class TodoNotFoundException extends RuntimeException {
    
}
