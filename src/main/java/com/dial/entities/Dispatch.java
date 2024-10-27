package com.dial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String dispatchId;
    Date dispatchDate;
    @ManyToOne
    @JoinColumn(name="arrival_id")
    @JsonIgnore
    Arrival arrival;
    Integer dispatchQty;
    @ManyToOne
    @JoinColumn(name="vehicle_id")
    Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name="party_id")
    Party party;
}
