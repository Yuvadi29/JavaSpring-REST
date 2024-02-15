package com.example.RestApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestApi.model.Data;
import com.example.RestApi.Routes.DataRoutes;

@Service
@Transactional
public class DataServicesImpl implements DataRoutes {

    @Autowired
    private DataServices dataServices;

    @Override
    public Data createData(Data data) {
        return dataServices.save(data);
    }

    @Override
    public Data updateData(Data data) {
        // Find the data by id
        Optional<Data> Data = this.dataServices.findById(data.getId());

        // Update the Data
        if (Data.isPresent()) {
            Data updateData = Data.get();
            updateData.setId(data.getId());
            updateData.setName(data.getName());
            updateData.setDescription(data.getDescription());
            dataServices.save(updateData);
            return updateData;
        } else {
            // throw new ResourceNotFoundException("Record Not found with id: " +
            // data.getId());
            System.out.println("Record Not Found with id: " + data.getId());
        }
        return data;
    }

    @Override
    public List<Data> getAllData() {
        return this.dataServices.findAll();
    }

    @Override
    public Data getAllDataById(long dataId) {
        Optional<Data> Data = this.dataServices.findById(dataId);

        if (Data.isPresent()) {
            return Data.get();
        } else {
            System.out.println("Record Not Found with id: " + dataId);
        }
        return null;
    }

    @Override
    public void deleteData(long dataId) {
        Optional<Data> Data = this.dataServices.findById(dataId);

        if (Data.isPresent()) {
            this.dataServices.delete(Data.get());
        } else {
            System.out.println("Record Not Found with id: " + dataId);
        }

    }

}
