package com.dial.service.impl;

import com.dial.dto.DispatchDto;
import com.dial.entities.Arrival;
import com.dial.entities.Dispatch;
import com.dial.entities.Product;
import com.dial.repo.DispatchRepository;
import com.dial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchService implements IDispatchService {

    private final DispatchRepository dispatchRepository;
    private final IArrivalService arrivalService;
    private final IVehicleService vehicleService;
    private final IPartyService partyService;
    private final IProductService productService;
    @Autowired
    public DispatchService(DispatchRepository dispatchRepository, IArrivalService arrivalService, IProductService productService, IVehicleService vehicleService, IPartyService partyService) {
        this.dispatchRepository = dispatchRepository;
        this.arrivalService = arrivalService;
        this.productService = productService;
        this.vehicleService = vehicleService;
        this.partyService = partyService;
    }

    @Override
    public Dispatch createDispatch(DispatchDto dispatchDto) {
        Dispatch dispatch = new Dispatch();
        dispatch.setDispatchDate(dispatchDto.getDispatchDate());
        dispatch.setDispatchQty(dispatchDto.getDispatchQty());
        Arrival arrival = arrivalService.fetchArrival(dispatchDto.getArrivalId());
        //update stack qty
        arrival.setCurrentStackQty(Math.abs(arrival.getCurrentStackQty() - dispatchDto.getDispatchQty()));
        dispatch.setArrival(arrival);
        // update stock
        Product product = productService.fetchProduct(arrival.getProduct().getProductId());
        product.setStock(Math.abs(product.getStock() - dispatchDto.getDispatchQty()));
        dispatch.setVehicle(vehicleService.fetchVehicle(dispatchDto.getVehicleId()));
        dispatch.setParty(partyService.fetchParty(dispatchDto.getPartyId()));
        return dispatchRepository.save(dispatch);
    }
}
