package com.dial.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer arrivalId;
    Date arrivalDate;
    Integer arrivalStackQty;
    Integer currentStackQty;
    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;
    @OneToMany(mappedBy="arrival")
    List<Dispatch> dispatchList;
}
