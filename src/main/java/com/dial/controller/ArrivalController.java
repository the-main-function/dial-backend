package com.dial.controller;

import com.dial.dto.ArrivalDto;
import com.dial.entities.Arrival;
import com.dial.service.IArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrivalController {
    private final IArrivalService arrivalService;
    @Autowired
    public ArrivalController(IArrivalService arrivalService) {
        this.arrivalService = arrivalService;
    }

    @PostMapping("/arrival")
    public ResponseEntity<Arrival> addArrival(@RequestBody ArrivalDto arrivalDto){
        return new ResponseEntity<>(arrivalService.createArrival(arrivalDto), HttpStatus.CREATED);
    }
}
