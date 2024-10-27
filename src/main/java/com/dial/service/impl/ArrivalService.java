package com.dial.service.impl;

import com.dial.dto.ArrivalDto;
import com.dial.entities.Arrival;
import com.dial.repo.ArrivalRepository;
import com.dial.service.IArrivalService;
import com.dial.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalService implements IArrivalService {
    private final ArrivalRepository arrivalRepository;
    private final IProductService productService;
    @Autowired
    public ArrivalService(ArrivalRepository arrivalRepository, IProductService productService) {
        this.arrivalRepository = arrivalRepository;
        this.productService = productService;
    }

    @Override
    public Arrival createArrival(ArrivalDto arrivalDto) {
        Arrival arrival = new Arrival();
        arrival.setArrivalDate(arrivalDto.getArrivalDate());
        arrival.setArrivalStackQty(arrivalDto.getStackQty());
        arrival.setProduct(productService.fetchProduct(arrivalDto.getProductId()));
        return arrivalRepository.save(arrival);
    }

    @Override
    public Arrival fetchArrival(Integer arrivalId) {
        return arrivalRepository.findById(arrivalId).orElseThrow(()->new RuntimeException());
    }
}
