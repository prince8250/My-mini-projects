package com.TaskManager.taskManager.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.taskManager.model.task;
import com.TaskManager.taskManager.repository.taskRepo;


@Service
public class taskService {
    
    @Autowired
    private taskRepo repo;

    public List<task> getAllTasks(){
        return repo.findAll();
    }

    public void addTask(task task) {
        repo.save(task);
    }

    public task getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void updateTask(Long id, task updatedTask) {
        task existingTask = repo.findById(id).orElse(null);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        existingTask.setUpdatedAt(LocalDateTime.now()) ;
        existingTask.setPriority(updatedTask.getPriority());

        repo.save(existingTask);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    public void addMultipleTasks(List<task> tasks) {
        repo.saveAll(tasks);
    }

    public List<task> filterTask(String priority, Boolean completed) {
        List<task> tasks = repo.findAll();
        Stream<task> stream = tasks.stream();
        
        if (priority != null && !priority.isEmpty()){
            stream = stream.filter(task -> task.getPriority().equalsIgnoreCase(priority));
        }
        if (completed !=null){
            stream =stream.filter(task -> task.isCompleted() == completed);
        }
        return stream.collect(Collectors.toList());
    }
}
