package com.vti.repository;

import com.vti.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlightRepository extends JpaRepository<Flight, Integer>, JpaSpecificationExecutor<Flight> {
    Flight findByFlightCode(String flightCode);

    boolean existsByFlightCode(String flightCode);
}
