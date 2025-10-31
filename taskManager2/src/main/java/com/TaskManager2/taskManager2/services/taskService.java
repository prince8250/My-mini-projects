package com.TaskManager2.taskManager2.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public void updateTask(UUID id, task updateTask){

        task repoTask = repo.findById(id).orElse(null);

        updateTask.setId(repoTask.getId());
        updateTask.setCreatedAt(repoTask.getCreatedAt());
        updateTask.setDescription(repoTask.getDescription());
        updateTask.setStatus(repoTask.getStatus());
        updateTask.setUpdatedAt(LocalDateTime.now());

        repo.save(updateTask);
    }

    public task getById(UUID id){
        task task = repo.findById(id).orElse(null);
        return task;
    }
}
