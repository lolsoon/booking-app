package com.vti.form;

import com.vti.entity.Tour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class TourFilterForm {
    private String search;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private Tour.TourStatus tourStatus;
    private int duration;
    private Double minSalePrice;
    private Double maxSalePrice;

}
