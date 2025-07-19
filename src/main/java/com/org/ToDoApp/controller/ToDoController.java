package com.org.ToDoApp.controller;

import com.org.ToDoApp.entities.ToDo;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {

    private static List<ToDo> todos ;

    public ToDoController(){
        todos = new ArrayList<>();
        todos.add(new ToDo("Buy groceries", "Milk, Bread, Eggs", false,"1"));
        todos.add(new ToDo("Finish project", "Complete the Spring Boot app", false,"1"));
        todos.add(new ToDo("Workout", "30 minutes of cardio", true,"2"));
    }


}
