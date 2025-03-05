package com.example.demo2.repository;

import com.example.demo2.Model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DeviceRepositoryy extends MongoRepository<Device, String> {

    // ✅ Find devices by email
    @Query("{ 'email' : { $regex: ?0, $options: 'i' } }") // Case-insensitive email search
    List<Device> findByEmail(String email);
}
