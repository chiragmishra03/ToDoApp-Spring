package com.org.ToDoApp.service;

import org.springframework.stereotype.Service;

@Service
public class FakeToDoService implements ToDoService{

    public String initial(){
        return "I am service";
    }

}
