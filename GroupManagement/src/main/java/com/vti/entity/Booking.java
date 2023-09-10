package com.vti.entity;

import com.vti.dto.TourDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "booking_code", nullable = false)
    private String bookingCode;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "adults")
    private int adults;
    @Column(name = "children")
    private int children;
    @Column(name = "infants")
    private int infants;
    @Column(name = "total_passenger")
    private int totalPassenger;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;
    @Column(name = "note")
    private String note;
    //    @Column(name = "booking_status", nullable = false)
//    private int bookingStatus = BookingStatus.BOOKING_WAITING;
    @Column(name = "booking_status", length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    public enum BookingStatus {
        BOOKING_WAITING, BOOKING_CANCEL, BOOKING_DONE
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
