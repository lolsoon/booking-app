package com.vti.controller;

import com.vti.dto.HotelDTO;
import com.vti.entity.Hotel;
import com.vti.form.HotelCreateForm;
import com.vti.form.HotelFilterForm;
import com.vti.form.HotelUpdateForm;
import com.vti.service.IHotelService;
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
@RequestMapping(value = "/api/v1/hotels")
@Validated
public class HotelController {
    @Autowired
    private IHotelService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<HotelDTO> findAll(Pageable pageable, HotelFilterForm form) {
        Page<Hotel> page = service.findAll(pageable, form);
        List<HotelDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<HotelDTO>>() {
                }.getType()
        );
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }
    @GetMapping("/id/{id}")
    public HotelDTO findById(@PathVariable("id") @HotelExistsById int id) {
        return mapper.map(service.findHotelById(id), HotelDTO.class);
    }
    @PostMapping
    public void create(@RequestBody @Valid HotelCreateForm form) {
        service.create(form);
    }
    @PutMapping("/id/{id}")
    public void update(@PathVariable("id") @HotelExistsById int id, @RequestBody @Valid HotelUpdateForm form) {
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") @HotelExistsById int id) {
        service.deleteById(id);
    }
}
