package com.vti.validation.validator;

import com.vti.repository.BookingRepository;
import com.vti.validation.anotation.BookingExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookingExistsByIdValidator implements ConstraintValidator<BookingExistsById, Integer> {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return bookingRepository.existsById(id);
    }
}
