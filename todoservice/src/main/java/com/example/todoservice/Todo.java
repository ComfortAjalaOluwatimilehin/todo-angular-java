package com.example.todoservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private boolean done;

    public Todo(){
        super();
    }

    public Todo(String title,String content, boolean done){
        super();
        this.title =title;
        this.content  =content;
        this.done = done;
    }


    public boolean getDone() {
        return done;
    }


    public void setDone(boolean done) {
        this.done = done;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId(){
        return id;
    }
    
}
