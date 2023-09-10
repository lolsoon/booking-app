package com.vti.validation.validator;

import com.vti.repository.BookingRepository;
import com.vti.validation.anotation.BookingNotExistsByCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookingNotExistsByCodeValidator implements ConstraintValidator<BookingNotExistsByCode, String> {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public boolean isValid(String bookingCode, ConstraintValidatorContext constraintValidatorContext) {
        return !bookingRepository.existsByBookingCode(bookingCode);
    }
}
