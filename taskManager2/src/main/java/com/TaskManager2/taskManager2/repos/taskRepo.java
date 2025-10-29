package com.TaskManager2.taskManager2.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager2.taskManager2.models.task;

@Repository
public interface taskRepo extends JpaRepository<task, UUID>{
    
}
