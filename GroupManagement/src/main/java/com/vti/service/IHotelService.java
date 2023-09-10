package com.vti.service;

import com.vti.entity.Hotel;
import com.vti.form.HotelCreateForm;
import com.vti.form.HotelFilterForm;
import com.vti.form.HotelUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHotelService {
    Page<Hotel> findAll(Pageable pageable, HotelFilterForm form);

    Hotel findHotelById(int id);

    void create(HotelCreateForm form);

    void update(HotelUpdateForm form);

    void deleteById(int id);

}
