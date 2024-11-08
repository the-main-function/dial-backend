package com.dial.service;

import com.dial.dto.ArrivalDto;
import com.dial.entities.Arrival;

import java.util.List;

public interface IArrivalService {

    Arrival createArrival(ArrivalDto arrivalDto);
    Arrival fetchArrival(Integer arrivalId);
    List<Arrival> fetchAllArrivals();
}
