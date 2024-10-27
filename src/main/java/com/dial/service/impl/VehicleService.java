package com.dial.service.impl;

import com.dial.entities.Vehicle;
import com.dial.repo.VehicleRepository;
import com.dial.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle fetchVehicle(Integer vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(()-> new RuntimeException());
    }
}
