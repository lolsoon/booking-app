package com.vti.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class FlightFilterForm {
    private String search;
    private String flightCode;
    private Double minPrice;
    private Double maxPrice;
    private LocalDate startDate;
    private LocalDate endDate;
}

