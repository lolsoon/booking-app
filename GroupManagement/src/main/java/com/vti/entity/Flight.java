package com.vti.entity;

import com.vti.dto.TourDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "flight_code", nullable = false)
    private String flightCode;
    @Column(name = "departure", nullable = false)
    private String departure;
    @Column(name = "destination", nullable = false)
    private String destination;
    @Column(name = "airline_name", nullable = false)
    private String airlineName;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
}
