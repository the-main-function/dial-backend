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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;
    String name;
    @OneToOne
    @JoinColumn(name="stock_id")
    Stock stock;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<Arrival> arrivalList;
}
