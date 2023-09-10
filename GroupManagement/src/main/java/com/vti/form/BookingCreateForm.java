package com.vti.form;

import com.vti.entity.Booking;
import com.vti.validation.anotation.BookingNotExistsByCode;
import com.vti.validation.anotation.TourNotExistsByCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreateForm {
    @NotBlank(message = "{BookingForm.bookingCode.NotBlank}")
    @Length(max = 50, message = "{BookingForm.bookingCode.Length}")
    @BookingNotExistsByCode
    private String bookingCode;

    @NotBlank(message = "{BookingForm.fullName.NotBlank}")
    @Length(max = 50, message = "{BookingForm.fullName.Length}")
    private String fullName;

    @NotBlank(message = "{BookingForm.email.NotBlank}")
    @Length(max = 50, message = "{BookingForm.email.Length}")
    private String email;

    @NotBlank(message = "{BookingForm.phoneNumber.NotBlank}")
    @Length(max = 20, message = "{BookingForm.phoneNumber.Length}")
    private String phoneNumber;

    @NotBlank(message = "{BookingForm.address.NotBlank}")
    @Length(max = 255, message = "{BookingForm.address.Length}")
    private String address;

    @Min(value = 1, message = "{BookingForm.adults.Min}")
    private int adults;

    @Min(value = 0, message = "{BookingForm.children.Min}")
    private int children;

    @Min(value = 0, message = "{BookingForm.infants.Min}")
    private int infants;

    @Min(value = 1, message = "{BookingForm.totalPassenger.Min}")
    private int totalPassenger;

    private Double totalAmount;

    @NotNull(message = "{BookingForm.bookingDate.NotNull}")
    private LocalDateTime bookingDate;

    @NotBlank(message = "{BookingForm.note.NotBlank}")
    private String note;

    @NotNull(message = "{BookingForm.bookingStatus.NotNull}")
    private Booking.BookingStatus bookingStatus;
}
