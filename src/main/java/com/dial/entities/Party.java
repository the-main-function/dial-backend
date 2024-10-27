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

public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer partyId;
    String partyName;
    @OneToMany(mappedBy = "party")
    @JsonIgnore
    List<Dispatch> dispatchList;

}
