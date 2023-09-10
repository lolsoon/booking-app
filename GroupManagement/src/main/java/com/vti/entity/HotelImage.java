package com.vti.entity;
import com.vti.dto.HotelDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "hotel_images")
public class HotelImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    // Quan hệ Many-to-One với Hotel
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
