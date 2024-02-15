package com.example.RestApi.Routes;

import com.example.RestApi.model.Data;

import java.util.List;

public interface DataRoutes {
    // Create
    Data createData(Data data);

    // Read
    List<Data> getAllData(Data data);

    Data getAllDataById(long dataId);

    // Update
    Data updateData(Data data);

    // Delete
    void deleteData(long id);
}
