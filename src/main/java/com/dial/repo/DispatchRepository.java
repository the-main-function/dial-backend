package com.dial.repo;

import com.dial.entities.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch, String> {
}
