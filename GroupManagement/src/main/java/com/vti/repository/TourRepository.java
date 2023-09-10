package com.vti.repository;

import com.vti.dto.TourDTO;
import com.vti.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer>, JpaSpecificationExecutor<Tour> {
    List<Tour> findTourByTourStatus(Tour.TourStatus tourStatus);

    boolean existsByTourCode(String tourCode);

    Tour findTourById(int id);

    Tour findByTourCode(String tourCode);
}
