package com.vti.service;

import com.vti.dto.BookingDTO;
import com.vti.dto.BookingUserDTO;
import com.vti.entity.Booking;
import com.vti.form.BookingCreateForm;
import com.vti.form.BookingFilterForm;
import com.vti.form.BookingUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IBookingService {
    Page<Booking> findAll(Pageable pageable, BookingFilterForm form);
    Booking findById(int id);

    Booking findByBookingCode(String bookingCode);

    List<BookingUserDTO> findBookingByFullName(String fullName);

    void create(BookingCreateForm form);

    void update(BookingUpdateForm form);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Booking b SET b.bookingStatus = 'DISABLED' WHERE b.id = :id")
    void disableById(int id);

    List<BookingUserDTO> findBookingsByUserId(int userId);
}
