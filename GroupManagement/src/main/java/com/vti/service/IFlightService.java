package com.vti.service;

import com.vti.entity.Flight;
import com.vti.entity.Hotel;
import com.vti.form.FlightCreateForm;
import com.vti.form.FlightFilterForm;
import com.vti.form.FlightUpdateForm;
import com.vti.specification.FlightSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFlightService {
    Page<Flight> findAll(Pageable pageable, FlightFilterForm form);

    Flight findFlightById(int id);

    Flight findByFlightCode(String flightCode);

    void create(FlightCreateForm form);

    void update(FlightUpdateForm form);

    void deleteById(int id);
}
