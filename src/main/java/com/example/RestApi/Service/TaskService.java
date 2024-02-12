package com.example.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApi.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // CRUD
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString())
        repository.save(task);
    }
}
