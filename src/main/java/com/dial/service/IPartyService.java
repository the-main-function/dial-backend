package com.dial.service;

import com.dial.entities.Party;

public interface IPartyService {

     Party createParty(Party party);
     Party fetchParty(Integer partyId);
}
