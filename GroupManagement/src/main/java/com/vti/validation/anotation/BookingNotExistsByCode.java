package com.vti.validation.anotation;

import com.vti.validation.validator.BookingNotExistsByCodeValidator;
import com.vti.validation.validator.FlightNotExistsByCodeValidator;
import com.vti.validation.anotation.BookingNotExistsByCode.List;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = {BookingNotExistsByCodeValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
public @interface BookingNotExistsByCode {
    String message() default "{BookingForm.bookingCode.NotExists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        BookingNotExistsByCode[] value();
    }
}
