package com.vti.controller;

import com.vti.dto.BookingDTO;
import com.vti.dto.TourDTO;
import com.vti.entity.Tour;
import com.vti.entity.TourDetail;
import com.vti.form.TourCreateForm;
import com.vti.form.TourFilterForm;
import com.vti.form.TourUpdateForm;
import com.vti.service.ITourService;
import com.vti.validation.anotation.TourExistsById;
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
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/tours")
@Validated
public class TourController {
    @Autowired
    private ITourService tourService;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public Page<TourDTO> findAll(Pageable pageable, TourFilterForm form) {
        Page<Tour> page = tourService.findAll(pageable, form);
        List<TourDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<TourDTO>>() {
                }.getType()
        );
//        for (TourDTO tourDTO : dtos) {
//            List<TourDTO.BookingDTO> bookingDTOS = tourDTO.getBookings();
//            for (TourDTO.BookingDTO bookingDTO : bookingDTOS) {
//                bookingDTO.add(linkTo(methodOn(BookingController.class).findById(bookingDTO.getId())).withSelfRel());
//            }
//            tourDTO.add(linkTo(methodOn(TourController.class).findById(tourDTO.getId())).withSelfRel());
//        }
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/id/{id}")
    public TourDTO findById(@PathVariable("id") @TourExistsById int id) {
        return mapper.map(tourService.findById(id), TourDTO.class)
                .add(linkTo(methodOn(TourController.class).findById(id)).withSelfRel());
    }


    @GetMapping("/tourCode/{tourCode}")
    public TourDTO findByTourCode(@PathVariable("tourCode") String tourCode) {
        return mapper.map(tourService.findByTourCode(tourCode), TourDTO.class);
    }

    @PostMapping
    public void create(@RequestBody @Valid TourCreateForm form) {
        tourService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") @TourExistsById int id, @RequestBody @Valid TourUpdateForm form) {
        form.setId(id);
        tourService.update(form);
    }

    @DeleteMapping("/delete/{id}")
    public void disableById(@PathVariable("id") @TourExistsById int id) {
        tourService.disableById(id);
    }
}
