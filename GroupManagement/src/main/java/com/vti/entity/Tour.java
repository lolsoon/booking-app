package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "tour_code", nullable = false)
    private String tourCode;
    @Column(name = "tour_name", nullable = false)
    private String tourName;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "description", nullable = false)
    @Lob
    private String description;
    @Column(name = "start_destination", nullable = false)
    private String startDestination;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "transport", nullable = false)
    private String transport;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "sale_price")
    private Double salePrice;
    @Column(name = "price_formatted", nullable = false)
    private String priceFormatted;
    @Column(name = "seats")
    private int seats;
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    @Column(name = "likes")
    private int likes;
//    @JsonIgnore
//    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
//    private List<TourImage> tourImages;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TourImage> tourImages;
    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @Column(name = "tour_status", length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Tour.TourStatus tourStatus;

    public enum TourStatus {
        TOUR_DA_DIEN_RA,
        TOUR_DANG_DIEN_RA,
        TOUR_SAP_DIEN_RA
    }

    public Tour(int id, String tourCode, String tourName, LocalDate startDate, int duration, String startDestination, String location, String transport, Double price, Double salePrice, String priceFormatted, int seats, int availableSeats, int likes, List<TourImage> tourImages) {
        this.id = id;
        this.tourCode = tourCode;
        this.tourName = tourName;
        this.startDate = startDate;
        this.duration = duration;
        this.startDestination = startDestination;
        this.location = location;
        this.transport = transport;
        this.price = price;
        this.salePrice = salePrice;
        this.priceFormatted = priceFormatted;
        this.seats = seats;
        this.availableSeats = availableSeats;
        this.likes = likes;
        this.tourImages = tourImages;
    }
}

