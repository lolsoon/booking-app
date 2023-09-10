package com.vti.form;

import com.vti.validation.anotation.FlightNotExistsByCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightCreateForm {
    @NotBlank(message = "{FlightForm.flightCode.NotBlank}")
    @Length(max = 225, message = "{FlightForm.flightCode.Length}")
    @FlightNotExistsByCode
    private String flightCode;
    @NotBlank(message = "{FlightForm.departure.NotBlank}")
    @Length(max = 225, message = "{FlightForm.departure.Length}")
    private String departure;
    @NotBlank(message = "{FlightForm.destination.NotBlank}")
    @Length(max = 225, message = "{FlightForm.destination.Length}")
    private String destination;
    @NotBlank(message = "{FlightForm.airlineName.NotBlank}")
    @Length(max = 225, message = "{FlightForm.airlineName.Length}")
    private String airlineName;
    @NotNull(message = "{FlightForm.price.NotNull}")
    @PositiveOrZero(message = "{FlightForm.price.PositiveOrZero}")
    private Double price;
    @NotNull(message = "{FlightForm.startDate.NotNull}")
    private LocalDateTime startDate;
    @NotNull(message = "{FlightForm.endDate.NotNull}")
    private LocalDateTime endDate;

}
