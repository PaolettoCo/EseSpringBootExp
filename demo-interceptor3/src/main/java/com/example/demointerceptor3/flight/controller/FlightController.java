package com.example.demointerceptor3.flight.controller;

import com.example.demointerceptor3.flight.Flight;
import com.example.demointerceptor3.flight.repository.FlightDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightDao flightDao;

    public FlightController(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }

    @PostMapping("/populate")
    public void populateFlights() {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + random.ints());
            flight.setFromAirport("Airport " + random.ints());
            flight.setToAirport("Airport " + random.ints());
            flight.setStatus(Flight.Status.ONTIME);

            flightDao.save(flight);
        }

    }

    @PostMapping("/provision")
    public void provisionFlights(@RequestParam(required = false) Integer count) {
        int flightCount = count != null ? count : 100;

        Random random = new Random();

        for (int i = 0; i < flightCount; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + (i + 1));
            flight.setFromAirport("Airport " + random.nextInt(100));
            flight.setToAirport("Airport " + random.nextInt(100));
            flight.setStatus(randomStatus(random));

            flightDao.save(flight);
        }
    }

    private Flight.Status randomStatus(Random random) {
        int statusValue = random.nextInt(3);
        return Flight.Status.values()[statusValue];
    }

    @GetMapping("/allPaged")
    public Page<Flight> getAllFlightsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return flightDao.findAll(PageRequest.of(page, limit, Sort.by("fromAirport").ascending()));
    }

    @GetMapping("/onTime")
    public List<Flight> getOnTimeFlights() {
        return flightDao.findByStatus(Flight.Status.ONTIME);
    }

    @GetMapping("/status/{p1}/{p2}")
    public List<Flight> getFlightsByStatus(@PathVariable Flight.Status p1, @PathVariable Flight.Status p2) {
        return flightDao.findByStatusIn(Arrays.asList(p1, p2));
    }
}
