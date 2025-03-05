package com.example.demo2;

import com.example.demo2.Model.Device;
import com.example.demo2.repository.DeviceRepositoryy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    
    @Autowired
    private DeviceRepositoryy deviceRepository;

    // ✅ Fetch devices by Email instead of UserID
    public List<Device> getDevicesByEmail(String email) {
        System.out.println("Fetching devices for Email: " + email);
        
        List<Device> devices = deviceRepository.findByEmail(email);

        if (devices.isEmpty()) {
            System.out.println("❌ No devices found for Email: " + email);
        } else {
            System.out.println("✅ Devices found: " + devices);
        }
        return devices;
    }
}
