package com.example.RestApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.Services.DataService;
import com.example.RestApi.model.Data;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    // Get
    @GetMapping("/data")
    public ResponseEntity<List<Data>> getAllData() {
        return ResponseEntity.ok().body(dataService.getAllData());
    }

    // Get by ID
    @GetMapping("/data/{id}")
    public ResponseEntity<Data> getAllDataById(@PathVariable long id) {
        return ResponseEntity.ok().body(dataService.getAllDataById(id));
    }

    // Create
    @PostMapping("/data")
    public ResponseEntity<Data> createData(@RequestBody Data data) {
        return ResponseEntity.ok().body(this.dataService.createData(data));
    }

    // Update
    @PutMapping("/data/{id}")
    public ResponseEntity<Data> updateData(@PathVariable long id, @RequestBody Data data) {
        data.setId(id);
        return ResponseEntity.ok().body(this.dataService.updateData(data));
    }

    // Delete
    @DeleteMapping("/data/{id}")
    public HttpStatus deleteData(@PathVariable long id) {
        this.dataService.deleteData(id);
        return HttpStatus.OK;
    }
}
