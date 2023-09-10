package com.vti.validation.validator;

import com.vti.repository.FlightRepository;
import com.vti.validation.anotation.FlightNotExistsByCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlightNotExistsByCodeValidator implements ConstraintValidator<FlightNotExistsByCode, String>{
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public boolean isValid(String flightCode, ConstraintValidatorContext constraintValidatorContext) {
        return !flightRepository.existsByFlightCode(flightCode);
    }
}
