package com.example.RestApi.Repository;

import com.example.RestApi.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<Data, Long> {
    
}
