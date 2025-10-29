package com.TaskManager2.taskManager2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager2.taskManager2.models.task;
import com.TaskManager2.taskManager2.services.taskService;

@RestController("/api")
public class taskController {

    @Autowired
    private taskService service;

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(@RequestBody task newTask){
        service.createTask(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/tasks")
    public ResponseEntity<List<task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }
}
