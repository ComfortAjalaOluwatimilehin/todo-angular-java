package com.example.todoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="User duplicate found")
public class DuplicateUserFoundException extends RuntimeException {
    
}
