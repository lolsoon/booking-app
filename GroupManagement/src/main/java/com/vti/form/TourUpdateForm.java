package com.vti.form;

import com.vti.entity.Schedule;
import com.vti.entity.Tour;
import com.vti.validation.anotation.TourExistsById;
import com.vti.validation.anotation.TourNotExistsByCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Lob;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourUpdateForm {
    @NotNull(message = "{TourForm.id.NotNull}")
    @TourExistsById
    private int id;

    @NotBlank(message = "{TourForm.tourCode.NotBlank}")
    @Length(max = 50, message = "{TourForm.tourCode.Length}")
    @TourNotExistsByCode
    private String tourCode;

    @NotBlank(message = "{TourForm.tourName.NotBlank}")
    @Length(max = 1023, message = "{TourForm.tourName.Length}")
    private String tourName;

    @NotNull(message = "{TourForm.startDate.NotNull}")
    private LocalDate startDate;

    @Min(value = 1, message = "{TourForm.duration.Min}")
    private int duration;

    @NotBlank(message = "{TourForm.tourName.NotBlank}")
    @Lob
    private String description;

    @NotBlank(message = "{TourForm.startDestination.NotBlank}")
    @Length(max = 1023, message = "{TourForm.startDestination.Length}")
    private String startDestination;

    @NotBlank(message = "{TourForm.location.NotBlank}")
    @Length(max = 255, message = "{TourForm.location.Length}")
    private String location;

    @NotBlank(message = "{TourForm.transport.NotBlank}")
    @Length(max = 255, message = "{TourForm.transport.Length}")
    private String transport;

    @Valid
    private Schedule schedule;

    @NotNull(message = "{TourForm.price.NotNull}")
    @PositiveOrZero(message = "{TourForm.price.PositiveOrZero}")
    private Double price;

    @NotNull(message = "{TourForm.salePrice.NotNull}")
    @PositiveOrZero(message = "{TourForm.salePrice.PositiveOrZero}")
    private Double salePrice;

    @Min(value = 1, message = "{TourForm.seats.Min}")
    private int seats;

    @Min(value = 1, message = "{TourForm.availableSeats.Min}")
    private int availableSeats;

    @Min(value = 0, message = "{TourForm.availableSeats.Min}")
    private int likes;

    @NotEmpty
    private List<String> imageUrls;

    @NotNull(message = "{TourForm.tourStatus.NotNull}")
    private Tour.TourStatus tourStatus;
}
