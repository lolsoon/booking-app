package com.vti.validation.validator;

import com.vti.repository.TourRepository;
import com.vti.validation.anotation.TourExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TourExistsByIdValidator implements ConstraintValidator<TourExistsById, Integer> {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return tourRepository.existsById(id);
    }

}
