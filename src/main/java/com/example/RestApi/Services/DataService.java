package com.example.RestApi.Services;

import java.util.List;

import com.example.RestApi.model.Data;

// Creating a Data Controller
public interface DataService  {
    // Create
    Data createData(Data data);

    // Read
    List<Data> getAllData();

    Data getAllDataById(long id);

    // Update
    Data updateData(Data data);

    // Delete
    void deleteData(long id);
}
