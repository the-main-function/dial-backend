package com.dial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class ArrivalDto {
    private Date arrivalDate;
    private Integer productId;
    private Integer stackQty;

}
