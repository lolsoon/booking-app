package com.vti.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class BookingUserDTO {
    private int id;
    private String bookingCode;
    private String fullName;
    private String email;
    private String startDestination;
    private String location;
    private LocalDate startDate;
    private int adults;
    private int children;
    private int infants;
    private int totalPassenger;
    private Double totalAmount;
    private LocalDateTime bookingDate;
    private String phoneNumber;
}
