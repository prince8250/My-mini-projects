package com.TaskManager.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager.taskManager.model.task;

@Repository
public interface taskRepo extends JpaRepository<task, Long>{
    
}
