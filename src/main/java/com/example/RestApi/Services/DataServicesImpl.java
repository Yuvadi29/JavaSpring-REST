package com.example.RestApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestApi.model.Data;
import com.example.RestApi.Exceptions.ResourceNotFoundException;
import com.example.RestApi.Repository.DataRepository;

@Service
@Transactional
public class DataServicesImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public Data createData(Data data) {
        return this.dataRepository.save(data);
    }

    @Override
    public Data updateData(Data data) {
        // Find the data by id
        Optional<Data> Data = this.dataRepository.findById(data.getId());

        // Update the Data
        if (Data.isPresent()) {
            Data updateData = Data.get();
            updateData.setId(data.getId());
            updateData.setName(data.getName());
            updateData.setDescription(data.getDescription());
            dataRepository.save(updateData);
            return updateData;
        } else {
            throw new ResourceNotFoundException("Record Not found with id: " + data.getId());
            // System.out.println("Record Not Found with id: " + data.getId());
        }
    }

    @Override
    public List<Data> getAllData() {
        return this.dataRepository.findAll();
    }

    @Override
    public Data getAllDataById(long dataId) {
        Optional<Data> Data = this.dataRepository.findById(dataId);

        if (Data.isPresent()) {
            return Data.get();
        } else {
            // System.out.println("Record Not Found with id: " + dataId);
            throw new ResourceNotFoundException("Record Not found with id: " + dataId);
        }
    }

    @Override
    public void deleteData(long dataId) {
        Optional<Data> Data = this.dataRepository.findById(dataId);

        if (Data.isPresent()) {
            this.dataRepository.delete(Data.get());
        } else {
            throw new ResourceNotFoundException("Record Not found with id: " + dataId);
        }

    }

}
