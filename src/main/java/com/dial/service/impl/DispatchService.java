package com.dial.service.impl;

import com.dial.dto.DispatchDto;
import com.dial.entities.Dispatch;
import com.dial.repo.DispatchRepository;
import com.dial.service.IArrivalService;
import com.dial.service.IDispatchService;
import com.dial.service.IPartyService;
import com.dial.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchService implements IDispatchService {

    private final DispatchRepository dispatchRepository;
    private final IArrivalService arrivalService;
    private final IVehicleService vehicleService;
    private final IPartyService partyService;
    @Autowired
    public DispatchService(DispatchRepository dispatchRepository, IArrivalService arrivalService, IVehicleService vehicleService, IPartyService partyService) {
        this.dispatchRepository = dispatchRepository;
        this.arrivalService = arrivalService;
        this.vehicleService = vehicleService;
        this.partyService = partyService;
    }

    @Override
    public Dispatch createDispatch(DispatchDto dispatchDto) {
        Dispatch dispatch = new Dispatch();
        dispatch.setDispatchDate(dispatchDto.getDispatchDate());
        dispatch.setDispatchQty(dispatchDto.getDispatchQty());
        dispatch.setArrival(arrivalService.fetchArrival(dispatchDto.getArrivalId()));
        dispatch.setVehicle(vehicleService.fetchVehicle(dispatchDto.getVehicleId()));
        dispatch.setParty(partyService.fetchParty(dispatchDto.getPartyId()));
        return dispatchRepository.save(dispatch);
    }
}
