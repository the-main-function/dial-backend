package com.dial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer vehicleId;
    String vehicleNumber;
    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    List<Dispatch> dispatchList;
}
