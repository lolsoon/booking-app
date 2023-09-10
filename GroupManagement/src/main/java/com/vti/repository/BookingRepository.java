package com.vti.repository;

import com.vti.dto.BookingDTO;
import com.vti.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>, JpaSpecificationExecutor<Booking> {
    boolean existsByBookingCode(String bookingCode);
    List<Booking> findByUserId(int userId);

    Booking findByBookingCode(String bookingCode);

    List<Booking> findBookingByFullName(String fullName);

//    List<Booking> findBookingByUserId(int id);
}
