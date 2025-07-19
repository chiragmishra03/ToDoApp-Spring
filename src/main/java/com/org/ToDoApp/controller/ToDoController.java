package com.org.ToDoApp.controller;

import com.org.ToDoApp.entities.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ToDoController {

    private static List<ToDo> toDoList ;

    public ToDoController(){
        toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1L,"Buy groceries", "Milk, Bread, Eggs", false,"1"));
        toDoList.add(new ToDo(2L,"Finish project", "Complete the Spring Boot app", false,"1"));
        toDoList.add(new ToDo(3L,"Workout", "30 minutes of cardio", true,"2"));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getTodos() {
        return ResponseEntity.ok(toDoList); // returns 200 OK with the list
    }


    @PostMapping("/todos")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo newToDo) {
        toDoList.add(newToDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDo); // returns 201 Created
    }


    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        for (ToDo toDo : toDoList) {
            if (toDo.getId()!=null && toDo.getId().equals(id)) {
                return ResponseEntity.ok(toDo);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id){
        for (ToDo toDo:toDoList){
            if (toDo.getId()!=null && toDo.getId().equals(id)) {
                toDoList.remove(toDo);
                return ResponseEntity.status(200).body("Deleted Successfully");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo newToDo,@PathVariable Long id){
        for (ToDo toDo:toDoList){
            if (toDo.getId()!=null && toDo.getId().equals(id)) {
                toDo.setCompleted(newToDo.isCompleted());
                toDo.setDescription(newToDo.getDescription());
                toDo.setTitle(newToDo.getTitle());
                return ResponseEntity.status(200).body(toDo);
            }
        }
        return ResponseEntity.notFound().build();
    }



}
