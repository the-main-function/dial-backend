package com.dial.controller;

import com.dial.entities.Party;
import com.dial.service.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {

    private final IPartyService partyService;
    @Autowired
    public PartyController(IPartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping("/party")
    public ResponseEntity<Party> addParty(@RequestBody Party party){
        return new ResponseEntity<>(partyService.createParty(party), HttpStatus.CREATED);
    }
}
