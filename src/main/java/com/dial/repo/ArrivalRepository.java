package com.dial.repo;

import com.dial.entities.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrivalRepository extends JpaRepository<Arrival, Integer> {
}
