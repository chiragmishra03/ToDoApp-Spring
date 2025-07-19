package com.org.ToDoApp.controller;

import com.org.ToDoApp.ToDoAppApplication;
import com.org.ToDoApp.entities.ToDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {

    private static List<ToDo> toDoList ;

    public ToDoController(){
        toDoList = new ArrayList<>();
        toDoList.add(new ToDo("Buy groceries", "Milk, Bread, Eggs", false,"1"));
        toDoList.add(new ToDo("Finish project", "Complete the Spring Boot app", false,"1"));
        toDoList.add(new ToDo("Workout", "30 minutes of cardio", true,"2"));
    }

    @GetMapping("/todos")
    public List<ToDo> getTodos(){
        return toDoList;
    }

    @PostMapping("/todos")
    public ToDo createToDo(@RequestBody ToDo newToDo){
        toDoList.add(newToDo);
        return newToDo;
    }


}
