package com.example.RestApi.Controllers;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RestApi.model.Data;

// Creating a Data Controller
public interface DataController extends MongoRepository<Data, Long> {

}
