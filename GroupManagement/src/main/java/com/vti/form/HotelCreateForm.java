package com.vti.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelCreateForm {
    @NotBlank(message = "{HotelForm.hotelName.NotBlank}")
    @Length(max = 1023, message = "{HotelForm.hotelName.Length}")
    private String hotelName;
    @NotBlank(message = "{HotelForm.address.NotBlank}")
    @Length(max = 1023, message = "{HotelForm.address.Length}")
    private String address;
    @NotBlank(message = "{HotelForm.phoneNumber.NotBlank}")
    @Length(max = 50, message = "{HotelForm.phoneNumber.Length}")
    private String phoneNumber;
    @NotBlank(message = "{HotelForm.imageUrls.NotBlank}")
    @Length(max = 1023, message = "{HotelForm.imageUrls.Length}")
    private List<String> imageUrls;
    @NotNull(message = "{HotelForm.checkInDate.NotNull}")
    private LocalDateTime checkInDate;
    @NotNull(message = "{HotelForm.checkOutDate.NotNull}")
    private LocalDateTime checkOutDate;
    @NotNull(message = "{HotelForm.pricePerNight.NotNull}")
    @PositiveOrZero(message = "{HotelForm.pricePerNight.PositiveOrZero}")
    private Double pricePerNight;
}
