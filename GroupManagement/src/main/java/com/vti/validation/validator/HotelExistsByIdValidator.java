package com.vti.validation.validator;

import com.vti.repository.HotelRepository;
import com.vti.validation.anotation.HotelExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HotelExistsByIdValidator implements ConstraintValidator<HotelExistsById, Integer> {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return hotelRepository.existsById(id);
    }
}
