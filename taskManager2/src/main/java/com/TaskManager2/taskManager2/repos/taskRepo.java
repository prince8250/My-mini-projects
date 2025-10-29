package com.TaskManager2.taskManager2.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager2.taskManager2.models.task;

public interface taskRepo extends JpaRepository<task, UUID>{
    
}
