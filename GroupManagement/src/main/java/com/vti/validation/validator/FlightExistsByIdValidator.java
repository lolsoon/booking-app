package com.vti.validation.validator;

import com.vti.repository.FlightRepository;
import com.vti.validation.anotation.FlightExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlightExistsByIdValidator implements ConstraintValidator<FlightExistsById, Integer> {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return flightRepository.existsById(id);
    }
}
