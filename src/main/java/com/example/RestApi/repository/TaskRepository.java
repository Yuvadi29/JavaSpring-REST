package com.example.RestApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RestApi.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
