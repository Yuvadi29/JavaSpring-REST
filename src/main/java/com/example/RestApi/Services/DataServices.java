package com.example.RestApi.Services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RestApi.model.Data;

// Creating a Data Controller
public interface DataServices extends MongoRepository<Data, Long> {

}
