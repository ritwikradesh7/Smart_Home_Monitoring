package com.example.demo2;

import com.example.demo2.Model.EnergyBudget;
import com.example.demo2.Model.Device;
import com.example.demo2.repository.EnergyBudgetRepository;
//import com.example.demo2.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyBudgetService {

    @Autowired
    private EnergyBudgetRepository energyBudgetRepository;

    @Autowired
    private DeviceService deviceService; // Inject DeviceService to fetch device energy consumption

    // ✅ Fetch energy budgets & check if exceeded
    public List<EnergyBudget> getEnergyBudgetsByEmail(String email) {
        System.out.println("Fetching Energy Budgets for Email: " + email);

        List<EnergyBudget> budgets = energyBudgetRepository.findByEmail(email);

        if (budgets.isEmpty()) {
            System.out.println("❌ No energy budgets found for Email: " + email);
            return budgets;
        }

        // 🔹 Get all devices for the user
        List<Device> devices = deviceService.getDevicesByEmail(email);

        // 🔹 Calculate total energy consumed
        double totalEnergyConsumed = devices.stream()
                .mapToDouble(Device::getEnergyConsumption_kWh)
                .sum();

        System.out.println("🔹 Total Energy Consumed: " + totalEnergyConsumed + " kWh");

        // 🔹 Check against budget & update alert status
        for (EnergyBudget budget : budgets) {
            boolean isExceeded = totalEnergyConsumed > budget.getEnergyBudget_kWh();
            budget.setAlertStatus(isExceeded);

            System.out.println("✅ Budget ID: " + budget.getBudgetID() +
                    " | Budget Limit: " + budget.getEnergyBudget_kWh() +
                    " kWh | Exceeded: " + isExceeded);
            
            // Save updated budget status
            energyBudgetRepository.save(budget);
        }

        return budgets;
    }
}
