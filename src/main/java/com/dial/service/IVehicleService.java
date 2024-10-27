package com.dial.service;

import com.dial.entities.Vehicle;

public interface IVehicleService {

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle fetchVehicle(Integer vehicleId);
}
