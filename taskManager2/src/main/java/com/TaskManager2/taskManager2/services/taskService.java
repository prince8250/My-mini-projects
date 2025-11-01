package com.TaskManager2.taskManager2.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public void updateTask(UUID id, task updatedTask){

        task repoTask = repo.findById(id).orElse(null);

        repoTask.setId(updatedTask.getId());
        repoTask.setCreatedAt(updatedTask.getCreatedAt());
        repoTask.setDescription(updatedTask.getDescription());
        repoTask.setStatus(updatedTask.getStatus());
        repoTask.setUpdatedAt(LocalDateTime.now());

        repo.save(repoTask);
    }

    public task getById(UUID id){
        task task = repo.findById(id).orElse(null);
        return task;
    }

    public List<task> filterTask(String status){
        List<task> tasks = repo.findAll();
        List<task> filtered = tasks.stream()
            .filter(task -> task.getStatus().equalsIgnoreCase(status))
            .collect(Collectors.toList());
        return filtered;
    }

    
}
