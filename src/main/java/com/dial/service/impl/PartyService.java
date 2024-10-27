package com.dial.service.impl;

import com.dial.entities.Party;
import com.dial.repo.PartyRepository;
import com.dial.service.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService implements IPartyService {
    private final PartyRepository partyRepository;

    @Autowired
    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Party createParty(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public Party fetchParty(Integer partyId) {
        return partyRepository.findById(partyId).orElseThrow(()-> new RuntimeException());
    }
}
