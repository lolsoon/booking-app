package com.vti.entity;

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
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Lob
    @Column(name = "activities", nullable = false)
    private String activities; // Mô tả hoạt động trong ngày

    @Lob
    @Column(name = "meals", nullable = false)
    private String meals; // Mô tả bữa ăn trong ngày

}
