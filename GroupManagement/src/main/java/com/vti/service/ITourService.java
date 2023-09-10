package com.vti.service;

import com.vti.dto.TourDTO;
import com.vti.entity.Tour;
import com.vti.form.TourCreateForm;
import com.vti.form.TourFilterForm;
import com.vti.form.TourUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITourService {
    Page<Tour> findAll(Pageable pageable, TourFilterForm form);

    Tour findById(int id);

    Tour findByTourCode(String tourCode);

    void create(TourCreateForm form);

    void update(TourUpdateForm form);

    void disableById(int id);

    List<Tour> findTourByTourStatus(Tour.TourStatus tourStatus);


//    void disableAll(List<Integer> ids);
}
