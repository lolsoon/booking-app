package com.vti.dto;

//import com.vti.entity.HotelImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class HotelDTO {
    private int id;
    private String hotelName;
    private String address;
    private String phoneNumber;
    private Double pricePerNight;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
}
