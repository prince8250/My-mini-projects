package com.TaskManager.taskManager.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.taskManager.model.task;
import com.TaskManager.taskManager.services.taskService;

@RequestMapping("/api/tasks")
@RestController
public class taskController {
    
    @Autowired
    private taskService service;

    @GetMapping
    public ResponseEntity<List<task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addTask(@RequestBody task task){
        service.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping("/multiple")
    public ResponseEntity<Void> addMultipleTasks(@RequestBody List<task> tasks){
        service.addMultipleTasks(tasks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<task> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id, @RequestBody task updatedTask){
        service.updateTask(id, updatedTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
