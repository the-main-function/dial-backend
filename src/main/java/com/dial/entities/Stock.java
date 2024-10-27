package com.dial.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer stockId;
    Integer qty;
    @OneToOne(mappedBy = "stock")
    Product product;

}
