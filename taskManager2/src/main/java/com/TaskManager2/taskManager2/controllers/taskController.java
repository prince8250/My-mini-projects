package com.TaskManager2.taskManager2.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager2.taskManager2.models.task;
import com.TaskManager2.taskManager2.services.taskService;

@RestController
@RequestMapping("/api")
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
    
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable UUID id, @RequestBody task updatedTask){
        service.updateTask(id, updatedTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<task> getById(@PathVariable UUID id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.FOUND);
    }

    @GetMapping("tasks/filter")
    public ResponseEntity<List<task>> filterTask(@RequestParam String status){
        return new ResponseEntity<>(service.filterTask(status), HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id){
        service.deleteTask(id);
        return new ResponseEntity<>("Task Deleted",HttpStatus.OK);
    }

}
