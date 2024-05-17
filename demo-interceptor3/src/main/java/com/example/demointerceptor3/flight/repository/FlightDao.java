package com.example.demointerceptor3.flight.repository;

import com.example.demointerceptor3.flight.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDao extends JpaRepository<Flight, Long> {

    List<Flight> findByStatus(Flight.Status status);

    List<Flight> findByStatusIn(List<Flight.Status> list);
}
