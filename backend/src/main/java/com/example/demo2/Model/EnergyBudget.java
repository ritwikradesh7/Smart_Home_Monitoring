package com.example.demo2.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "energy_budgets")
public class EnergyBudget {
    
    @Id
    private String id;
    private String BudgetID;
    private String userID;
    private String email;
    private double EnergyBudget_kWh;
    private String BudgetStartDate;
    private String BudgetEndDate;
    private boolean AlertStatus;

    // ✅ Constructors
    public EnergyBudget() {}

    public EnergyBudget(String BudgetID, String userID, String email, double EnergyBudget_kWh, String BudgetStartDate, String BudgetEndDate, boolean AlertStatus) {
        this.BudgetID = BudgetID;
        this.userID = userID;
        this.email = email;
        this.EnergyBudget_kWh = EnergyBudget_kWh;
        this.BudgetStartDate = BudgetStartDate;
        this.BudgetEndDate = BudgetEndDate;
        this.AlertStatus = AlertStatus;
    }

    // ✅ Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBudgetID() { return BudgetID; }
    public void setBudgetID(String BudgetID) { this.BudgetID = BudgetID; }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getEnergyBudget_kWh() { return EnergyBudget_kWh; }
    public void setEnergyBudget_kWh(double EnergyBudget_kWh) { this.EnergyBudget_kWh = EnergyBudget_kWh; }

    public String getBudgetStartDate() { return BudgetStartDate; }
    public void setBudgetStartDate(String BudgetStartDate) { this.BudgetStartDate = BudgetStartDate; }

    public String getBudgetEndDate() { return BudgetEndDate; }
    public void setBudgetEndDate(String BudgetEndDate) { this.BudgetEndDate = BudgetEndDate; }

    public boolean isAlertStatus() { return AlertStatus; }
    public void setAlertStatus(boolean AlertStatus) { this.AlertStatus = AlertStatus; }
}
