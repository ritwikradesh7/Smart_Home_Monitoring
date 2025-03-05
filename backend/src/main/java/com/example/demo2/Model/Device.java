package com.example.demo2.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
public class Device {

    @Id
    private String id;
    private String UserID;
    private String DeviceName;
    private String DeviceType;
    private String DeviceStatus;
    private String LastDataUpdate;
    private int PowerConsumption;
    private double EnergyConsumption_kWh;
    private String DeviceID;
    private String email;

    public Device() {}

    public Device(String id, String email, String DeviceName,String UserID,String DeviceType) {
        this.id = id;
        this.email = email;
        this.DeviceName = DeviceName;
        this.UserID=UserID;
        this.DeviceType=DeviceType;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserID() { return UserID; }
    public void setUserID(String UserID) { this.UserID = UserID; }

    public String getDeviceName() { return DeviceName; }
    public void setDeviceName(String deviceName) { this.DeviceName = deviceName; }

    public String getDeviceType() { return DeviceType; }
    public void setDeviceType(String deviceType) { this.DeviceType = deviceType; }

    public String getDeviceStatus() { return DeviceStatus; }
    public void setDeviceStatus(String deviceStatus) { this.DeviceStatus = deviceStatus; }

    public String getLastDataUpdate() { return LastDataUpdate; }
    public void setLastDataUpdate(String lastDataUpdate) { this.LastDataUpdate = lastDataUpdate; }

    public int getPowerConsumption() { return PowerConsumption; }
    public void setPowerConsumption(int powerConsumption) { this.PowerConsumption = powerConsumption; }

    public double getEnergyConsumption_kWh() { return EnergyConsumption_kWh; }
    public void setEnergyConsumption_kWh(double energyConsumption_kWh) { this.EnergyConsumption_kWh = energyConsumption_kWh; }

    public String getDeviceID() { return DeviceID; }
    public void setDeviceID(String deviceID) { this.DeviceID = deviceID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}
