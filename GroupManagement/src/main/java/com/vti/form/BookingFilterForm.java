package com.vti.form;

import com.vti.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingFilterForm {
    private String search;
    private String bookingCode;
    private Booking.BookingStatus bookingStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minBookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxBookingDate;
    private Double minTotalAmount;
    private Double maxTotalAmount;
}
