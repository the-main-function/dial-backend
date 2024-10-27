package com.dial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class DispatchDto {

    private Date dispatchDate;
    private Integer arrivalId;
    private Integer vehicleId;
    private Integer partyId;
    private Integer dispatchQty;
}
