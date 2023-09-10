package com.vti.dto;

import com.vti.entity.Booking;
import com.vti.entity.Flight;
import com.vti.entity.Hotel;
import com.vti.entity.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TourDTO extends RepresentationModel<TourDTO> {
    private int id;
    private String tourCode;
    private String tourName;
    //    private String tourPriceString;
    private LocalDate startDate;
    private int duration;
    private Double price;
    private Double salePrice;
    private String startDestination;
    private String location;
    private String transport;
    private int seats;
    private int availableSeats;
    private Tour.TourStatus tourStatus;
    private FlightDTO flight;
    private HotelDTO hotel;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "flight_id")
//    private Flight flight;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
//    private List<BookingDTO> bookings;
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class BookingDTO extends RepresentationModel<BookingDTO> {
//        private int id;
//        private String bookingCode;
//        private String fullName;
//        private String email;
//        private String phoneNumber;
//        private String address;
//        private int adults;
//        private int children;
//        private int infants;
//        private int totalPassenger;
//        private Double totalAmount;
//        private LocalDateTime bookingDate;
//        private String note;
//        private Booking.BookingStatus bookingStatus;
//    }
}
