package com.vti.controller;

import com.vti.dto.BookingDTO;
import com.vti.dto.BookingUserDTO;
import com.vti.dto.TourDTO;
import com.vti.entity.Booking;
import com.vti.form.BookingCreateForm;
import com.vti.form.BookingFilterForm;
import com.vti.form.BookingUpdateForm;
import com.vti.repository.BookingRepository;
import com.vti.service.IBookingService;
import com.vti.validation.anotation.BookingExistsById;
import com.vti.validation.anotation.BookingNotExistsByCode;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<BookingDTO> findAll(Pageable pageable, BookingFilterForm form) {
        Page<Booking> page = bookingService.findAll(pageable, form);
        List<BookingDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<BookingDTO>>() {
                }.getType()
        );
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/id/{id}")
    public BookingDTO findById(@PathVariable("id") @BookingExistsById int id) {
        return mapper.map(bookingService.findById(id), BookingDTO.class);
    }


    @GetMapping("/bookingCode/{bookingCode}")
    public BookingDTO findBookingByCode(@PathVariable("bookingCode") String bookingCode) {
        return mapper.map(bookingService.findByBookingCode(bookingCode), BookingDTO.class);
    }

    @GetMapping("/full_name/{fullName}")
    public ResponseEntity<?> getBookingByNameKH ( @PathVariable String fullName) {
        List<BookingUserDTO> bookingDTOS = bookingService.findBookingByFullName(fullName);
        return new ResponseEntity<>(bookingDTOS , HttpStatus.OK);
    }

    // GET BOOKING BY USER ID
    @GetMapping("/userId/{userId}")
    public ResponseEntity<?> findBookingsByUserId ( @PathVariable int userId) {
        List<BookingUserDTO> bookingDTOS = bookingService.findBookingsByUserId(userId);
        return new ResponseEntity<>(bookingDTOS , HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody @Valid BookingCreateForm form) {
        bookingService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") @BookingExistsById int id, @RequestBody @Valid BookingUpdateForm form) {
        form.setId(id);
        bookingService.update(form);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") @BookingExistsById int id) {
        bookingService.disableById(id);
    }

}
