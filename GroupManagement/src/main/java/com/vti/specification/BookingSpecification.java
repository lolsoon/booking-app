package com.vti.specification;

import com.vti.entity.*;
import com.vti.form.BookingFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingSpecification {
    public static Specification<Booking> buildWhere(BookingFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasBookingCodeIs(form.getBookingCode())
                .and(hasFullNameLike(form.getSearch()))
                .and(hasEmailIs(form.getSearch()))
                .and(hasPhoneNumberIs(form.getSearch()))
                .and(hasBookingStatusIs(form.getBookingStatus()))
                .and(hasBookingDateGreaterThanOrEqualTo(form.getMinBookingDate()))
                .and(hasBookingDateLessThanOrEqualTo(form.getMaxBookingDate()))
                .and(hasTotalAmountGreaterThanEqualTo(form.getMinTotalAmount()))
                .and(hasTotalAmountLessThanEqualTo(form.getMaxTotalAmount()))
                ;
    }

    private static Specification<Booking> hasBookingCodeIs(String bookingCode) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (bookingCode == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("bookingCode"), bookingCode);
        };
    }

    public static Specification<Booking> hasFullNameLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("fullName"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Booking> hasEmailIs(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(email)) {
                return null;
            }
            return criteriaBuilder.like(root.get("email"), "%" + email.trim() + "%");
        };
    }

    private static Specification<Booking> hasPhoneNumberIs(String phoneNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (phoneNumber == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
        };
    }

    private static Specification<Booking> hasBookingStatusIs(Booking.BookingStatus bookingStatus) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (bookingStatus == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("bookingStatus"), bookingStatus);
        };
    }

    private static Specification<Booking> hasBookingDateGreaterThanOrEqualTo(LocalDate minBookingDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (minBookingDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("bookingDate"), minBookingDate);
        };
    }

    private static Specification<Booking> hasBookingDateLessThanOrEqualTo(LocalDate maxBookingDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (maxBookingDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("bookingDate"), maxBookingDate);
        };
    }

    private static Specification<Booking> hasTotalAmountGreaterThanEqualTo(Double minTotalAmount) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (minTotalAmount == null) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), minTotalAmount);
        };
    }

    private static Specification<Booking> hasTotalAmountLessThanEqualTo(Double maxTotalAmount) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (maxTotalAmount == null) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxTotalAmount);
        };
    }
}
