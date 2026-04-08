package com.example.FirstProject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {


    private  static List<Todo> todoList;


    public TodoController(){
        todoList =  new ArrayList<>();
        todoList.add(new Todo(1,false , "todo one ",  1 ));
        todoList.add(new Todo(2, true ,  "todo two ", 2 ));


    }


    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return  todoList;

    }

//creating newtodos and stroing in the arraylist using the postman

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.ACCEPTED)     // we can use this to set the status whether it is accpeted in 201
    public List<Todo> creatTodos(@RequestBody Todo newtodo){



        todoList.add(newtodo);
        return  todoList;


    }



    @GetMapping("/todos/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable  long todoId){  //another way of gettinng the status

        for (Todo todo  : todoList){
            if (todo.getId()==todoId){
                return  ResponseEntity.ok(todo);


            }
        }

        return  ResponseEntity.notFound().build();

    }




}

