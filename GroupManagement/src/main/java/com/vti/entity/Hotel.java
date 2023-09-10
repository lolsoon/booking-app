package com.vti.entity;

import com.vti.dto.TourDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

//    @Column(name = "img_urls", nullable = false)
//    private List<String> imgUrls;
    // Quan hệ One-to-Many với HotelImage
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelImage> images;

    @Column(name = "check_in_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime checkInDate;

    @Column(name = "check_out_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime checkOutDate;

    @Column(name = "price_per_night", nullable = false)
    private Double pricePerNight;


}
