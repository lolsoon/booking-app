package com.vti.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class FlightDTO {
    private int id;
    private String flightCode;
    private String departure;
    private String destination;
    private String airlineName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
