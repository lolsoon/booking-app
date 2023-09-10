package com.vti.service;

import com.vti.dto.TourDTO;
import com.vti.entity.Tour;
import com.vti.form.TourCreateForm;
import com.vti.form.TourFilterForm;
import com.vti.form.TourUpdateForm;
import com.vti.repository.TourRepository;
import com.vti.specification.TourSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService implements ITourService {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private ModelMapper modelMapper;

    //    @Override
//    public Page<Tour> findAll( Pageable pageable,TourFilterForm form) {
//        Page<Tour> tours = tourRepository.findAll(TourSpecification.buildWhere(form), pageable);
//        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
//        // format thành .000.000
//        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
//        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
//        decimalFormatSymbols.setGroupingSeparator('.');
//        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
//
//        for (Tour tour : tours) {
//            double price = tour.getPrice();
//            String formattedPrice = decimalFormat.format(price);
//            tour.setPriceFormatted(formattedPrice); // Giả sử bạn có một trường priceFormatted để lưu giá tiền đã định dạng
//        }
//        return tourRepository.findAll(TourSpecification.buildWhere(form), pageable);
//    }
    @Override
    public Page<Tour> findAll(Pageable pageable, TourFilterForm form) {
        return tourRepository.findAll(TourSpecification.buildWhere(form), pageable);
    }

    @Override
    public Tour findById(int id) {
        return tourRepository.findTourById(id);
    }

    @Override
    public Tour findByTourCode(String tourCode) {
        return tourRepository.findByTourCode(tourCode);
    }

    @Override
    public void create(TourCreateForm form) {
        tourRepository.save(modelMapper.map(form, Tour.class));
    }

    @Override
    public void update(TourUpdateForm form) {
        tourRepository.save(modelMapper.map(form, Tour.class));
    }

    @Override
    public void disableById(int id) {
        tourRepository.deleteById(id);
    }

    @Override
    public List<Tour> findTourByTourStatus(Tour.TourStatus tourStatus) {
        return tourRepository.findTourByTourStatus(tourStatus);
    }

//    @Override
//    public void disableAll(List<Integer> ids) {
//        tourRepository.deleteAll();
//    }
}
