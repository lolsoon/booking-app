package com.vti.entity;

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
@Table(name = "tour_details")
public class TourDetail {
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
    @Column(name = "start_destination", nullable = false)
    private String startDestination;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "sale_price")
    private Double salePrice;
    @Column(name = "percent_down")
    private Integer percentDown;
    @Column(name = "seats")
    private int seats;
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    @Column(name = "likes")
    private int likes;
    @OneToMany(mappedBy = "tourDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TourImage> tourImages ;
    public int getPercentDown() {
        if (price == 0) {
            return 0; // Tránh chia cho 0
        }
        double percentDown = ((price - salePrice) / price) * 100;
        return (int) percentDown;
    }
//    @OneToOne
//    @JoinColumn(name = "tour_id")
//    private Tour tour;

}
