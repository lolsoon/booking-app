package com.vti.dto;

import com.vti.entity.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO extends RepresentationModel<BookingDTO> {
    private int id;
    private String bookingCode;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private int adults;
    private int children;
    private int infants;
    private int totalPassenger;
    private Double totalAmount;
    private LocalDateTime bookingDate;
    private String note;
    private Booking.BookingStatus bookingStatus;
    private TourDTO tour;


//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class TourDTO extends RepresentationModel<TourDTO> {
//        private int id;
//        private String tourCode;
//        private Tour.TourStatus tourStatus;
//        private Flight flight;
//        private Hotel hotel;
//    }
}
