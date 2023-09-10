package com.vti.service;

import com.vti.dto.BookingDTO;
import com.vti.dto.BookingUserDTO;
import com.vti.entity.Booking;
import com.vti.form.BookingCreateForm;
import com.vti.form.BookingFilterForm;
import com.vti.form.BookingUpdateForm;
import com.vti.repository.BookingRepository;
import com.vti.specification.BookingSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Booking> findAll(Pageable pageable, BookingFilterForm form) {
        return bookingRepository.findAll(BookingSpecification.buildWhere(form), pageable);
    }

    @Override
    public Booking findById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByBookingCode(String bookingCode) {
        return bookingRepository.findByBookingCode(bookingCode);
    }

    @Override
    public List<BookingUserDTO> findBookingByFullName(String fullName) {
        // Sử dụng repository để truy vấn các đặt phòng dựa trên fullName
        List<Booking> bookings = bookingRepository.findBookingByFullName(fullName);

        // Chuyển đổi danh sách các đặt phòng sang danh sách DTO
        List<BookingUserDTO> bookingUserDTOs = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingUserDTO bookingUserDTO = new BookingUserDTO();
            // Sao chép thông tin từ Booking sang BookingUserDTO ở đây
            bookingUserDTOs.add(bookingUserDTO);
        }

        return bookingUserDTOs;
    }

    public List<BookingUserDTO> findBookingsByUserId(int userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream()
                .map(booking -> mapper.map(booking, BookingUserDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public void create(BookingCreateForm form) {
        TypeMap<BookingCreateForm, Booking> typeMap = mapper.getTypeMap(BookingCreateForm.class, Booking.class);
        if (typeMap == null) {
            mapper.addMappings(new PropertyMap<BookingCreateForm, Booking>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        bookingRepository.save(mapper.map(form, Booking.class));
    }


    @Override
    public void update(BookingUpdateForm form) {
        bookingRepository.save(mapper.map(form, Booking.class));
    }

    @Override
    public void disableById(int id) {
        bookingRepository.deleteById(id);
    }


//    @Transactional
//    public void disableBookingById(int id) {
//        // Kiểm tra xem Booking có tồn tại hay không
//        Booking booking = bookingRepository.findById(id);
//        if (booking == null) {
//            throw new NotFoundException("Booking not found with id: " + id);
//        }
//
//        // Gọi phương thức vô hiệu hóa từ BookingRepository
//        bookingRepository.disableById(id);
//    }
}
