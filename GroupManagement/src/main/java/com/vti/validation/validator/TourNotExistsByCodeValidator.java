package com.vti.validation.validator;

import com.vti.repository.TourRepository;
import com.vti.validation.anotation.TourNotExistsByCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TourNotExistsByCodeValidator implements ConstraintValidator<TourNotExistsByCode, String> {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public boolean isValid(String tourCode, ConstraintValidatorContext constraintValidatorContext) {
        return !tourRepository.existsByTourCode(tourCode);
    }
}
