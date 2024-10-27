package com.dial.service;

import com.dial.dto.ArrivalDto;
import com.dial.entities.Arrival;

public interface IArrivalService {

    Arrival createArrival(ArrivalDto arrivalDto);
    Arrival fetchArrival(Integer arrivalId);
}
