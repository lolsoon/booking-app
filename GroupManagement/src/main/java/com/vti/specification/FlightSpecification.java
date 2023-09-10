package com.vti.specification;

import com.vti.entity.Flight;
import com.vti.form.FlightFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class FlightSpecification {
    public static Specification<Flight> buildWhere(FlightFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasFlightCodeIs(form.getFlightCode())
                .and(hasAirlineLike(form.getSearch()))
                .and(hasDestinationLike(form.getSearch()))
                .and(hasStartDateGreaterThanEqualTo(form.getStartDate()))
                .and(hasEndDateGreaterThanEqualTo(form.getEndDate()))
                .and(hasMinPriceGreaterThanEqualTo(form.getMinPrice()))
                .and(hasMaxPriceGreaterThanEqualTo(form.getMaxPrice()));
    }

    private static Specification<Flight> hasFlightCodeIs(String flightCode) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (flightCode == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("flightCode"), flightCode);
        };
    }

    private static Specification<Flight> hasAirlineLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("airlineName"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Flight> hasDestinationLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("destination"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Flight> hasStartDateGreaterThanEqualTo(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (startDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), startDate);
        };

    }

    private static Specification<Flight> hasEndDateGreaterThanEqualTo(LocalDate endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (endDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), endDate);
        };

    }

    private static Specification<Flight> hasPriceIn(Double minPrice, Double maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice),
                        criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice)
                );
    }

    private static Specification<Flight> hasMinPriceGreaterThanEqualTo(Double minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (minPrice == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
        };

    }

    private static Specification<Flight> hasMaxPriceGreaterThanEqualTo(Double maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (maxPrice == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), maxPrice);
        };

    }

}
