package com.vti.specification;

import com.vti.entity.Hotel;
import com.vti.entity.Tour;
import com.vti.form.HotelFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class HotelSpecification {
    public static Specification<Hotel> buildWhere(HotelFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasHotelNameLike(form.getSearch())
                .and(hasAddressLike(form.getSearch()))
                .and(hasCheckInDateGreaterThanEqualTo(form.getCheckInDate()))
                .and(hasCheckOutDateGreaterThanEqualTo(form.getCheckOutDate()))
                .and(hasPriceGreaterThanOrEqualTo(form.getMinPrice()))
                .and(hasPriceLessThanOrEqualTo(form.getMaxPrice()));
    }

    private static Specification<Hotel> hasHotelNameLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("hotelName"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Hotel> hasAddressLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("address"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Hotel> hasCheckInDateGreaterThanEqualTo(LocalDate checkInDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (checkInDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("checkInDate").as(LocalDate.class), checkInDate);
        };
    }

    private static Specification<Hotel> hasCheckOutDateGreaterThanEqualTo(LocalDate checkOutDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (checkOutDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("checkOutDate").as(LocalDate.class), checkOutDate);
        };
    }
    private static Specification<Hotel> hasPriceGreaterThanOrEqualTo(Double minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (minPrice == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("pricePerNight"), minPrice);
        };

    }

    private static Specification<Hotel> hasPriceLessThanOrEqualTo(Double maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (maxPrice == null) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("pricePerNight"), maxPrice);
        };
    }

}
