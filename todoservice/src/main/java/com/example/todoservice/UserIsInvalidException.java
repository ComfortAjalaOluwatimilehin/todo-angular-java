package com.example.todoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Username or password is invalid")
public class UserIsInvalidException  extends RuntimeException{
    
}
