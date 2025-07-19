package com.org.ToDoApp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AnotherToDoService implements ToDoService{

    public String initial(){
        return "Another todo service";
    }
}
