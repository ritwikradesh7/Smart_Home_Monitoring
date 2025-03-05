package com.example.demo2.repository;


import com.example.demo2.Model.EnergyBudget;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EnergyBudgetRepository extends MongoRepository<EnergyBudget, String> {
    List<EnergyBudget> findByEmail(String email);
}
