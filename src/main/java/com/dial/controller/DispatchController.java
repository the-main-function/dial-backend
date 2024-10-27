package com.dial.controller;

import com.dial.dto.DispatchDto;
import com.dial.entities.Dispatch;
import com.dial.service.IDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatchController {

    private final IDispatchService dispatchService;
    @Autowired
    public DispatchController(IDispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }

    @PostMapping("/dispatch")
    public ResponseEntity<Dispatch> addDispatch(@RequestBody DispatchDto dispatchDto){
        return new ResponseEntity<>(dispatchService.createDispatch(dispatchDto), HttpStatus.CREATED);
    }
}
