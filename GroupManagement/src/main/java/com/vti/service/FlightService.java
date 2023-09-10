package com.vti.service;

import com.vti.entity.Flight;
import com.vti.entity.Hotel;
import com.vti.form.FlightCreateForm;
import com.vti.form.FlightFilterForm;
import com.vti.form.FlightUpdateForm;
import com.vti.repository.FlightRepository;
import com.vti.repository.HotelRepository;
import com.vti.specification.FlightSpecification;
import com.vti.specification.HotelSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightService implements  IFlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Flight> findAll(Pageable pageable, FlightFilterForm form) {
        return flightRepository.findAll(FlightSpecification.buildWhere(form), pageable);
    }

    @Override
    public Flight findFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public Flight findByFlightCode(String flightCode) {
        return flightRepository.findByFlightCode(flightCode);
    }

    @Override
    public void create(FlightCreateForm form) {
        flightRepository.save(modelMapper.map(form, Flight.class));
    }

    @Override
    public void update(FlightUpdateForm form) {
        flightRepository.save(modelMapper.map(form, Flight.class));
    }

    @Override
    public void deleteById(int id) {
    flightRepository.deleteById(id);
    }
}
