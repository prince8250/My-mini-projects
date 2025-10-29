package com.TaskManager2.taskManager2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager2.taskManager2.models.task;
import com.TaskManager2.taskManager2.repos.taskRepo;

@Service
public class taskService {

    @Autowired
    private taskRepo repo;
    
    public List<task> getAllTasks(){
        return repo.findAll();
    }

    public void createTask(task newTask) {
       repo.save(newTask);
    }
}
