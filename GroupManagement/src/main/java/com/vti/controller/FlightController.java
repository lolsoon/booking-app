package com.vti.controller;

import com.vti.dto.FlightDTO;
import com.vti.dto.HotelDTO;
import com.vti.dto.TourDTO;
import com.vti.entity.Flight;
import com.vti.entity.Hotel;
import com.vti.form.*;
import com.vti.service.IFlightService;
import com.vti.service.IHotelService;
import com.vti.validation.anotation.FlightExistsById;
import com.vti.validation.anotation.HotelExistsById;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/flights")
@Validated
public class FlightController {
    @Autowired
    private IFlightService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<FlightDTO> findAll(Pageable pageable, FlightFilterForm form) {
        Page<Flight> page = service.findAll(pageable, form);
        List<FlightDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<FlightDTO>>() {
                }.getType()
        );
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }
    @GetMapping("/id/{id}")
    public FlightDTO findById(@PathVariable("id") @FlightExistsById int id) {
        return mapper.map(service.findFlightById(id), FlightDTO.class);
    }
    @PostMapping
    public void create(@RequestBody @Valid FlightCreateForm form) {
        service.create(form);
    }
    @GetMapping("/flightCode/{flightCode}")
    public FlightDTO findByFlightCode(@PathVariable("flightCode") String flightCode) {
        return mapper.map(service.findByFlightCode(flightCode), FlightDTO.class);
    }
    @PutMapping("/id/{id}")
    public void update(@PathVariable("id") @FlightExistsById int id, @RequestBody @Valid FlightUpdateForm form) {
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") @FlightExistsById int id) {
        service.deleteById(id);
    }
}
