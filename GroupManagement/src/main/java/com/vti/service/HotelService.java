package com.vti.service;

import com.vti.entity.Hotel;
import com.vti.entity.Tour;
import com.vti.form.HotelCreateForm;
import com.vti.form.HotelFilterForm;
import com.vti.form.HotelUpdateForm;
import com.vti.form.TourFilterForm;
import com.vti.repository.HotelRepository;
import com.vti.specification.HotelSpecification;
import com.vti.specification.TourSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Hotel> findAll(Pageable pageable, HotelFilterForm form) {
        return hotelRepository.findAll(HotelSpecification.buildWhere(form), pageable);
    }


    @Override
    public Hotel findHotelById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public void create(HotelCreateForm form) {
        hotelRepository.save(modelMapper.map(form, Hotel.class));
    }

    @Override
    public void update(HotelUpdateForm form) {
        hotelRepository.save(modelMapper.map(form, Hotel.class));
    }

    @Override
    public void deleteById(int id) {
        hotelRepository.deleteById(id);
    }
}
