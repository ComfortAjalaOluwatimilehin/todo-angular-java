package com.example.todoservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {
    private final String username;
    private final String password;
    @Id
    @GeneratedValue
    private  Long id;


    public User(final String username, final String password){
        this.username = username;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    public Long getId(){
        return id;
    }


}
