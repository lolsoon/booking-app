package com.vti.specification;

import com.vti.entity.Tour;
import com.vti.form.TourFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class TourSpecification {
    public static Specification<Tour> buildWhere(TourFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasTourNameLike(form.getSearch())
                .and(hasTourCodeIs(form.getSearch()))
                .and(hasDurationGreaterThanEqualTo(form.getDuration()))
                .and(hasStartDateGreaterThanEqualTo(form.getStartDate()))
                .and(hasStartDestinationLike(form.getSearch()))
                .and(hasLocationLike(form.getSearch()))
                .and(hasSalePriceGreaterThanOrEqualTo(form.getMinSalePrice()))
                .and(hasSalePriceLessThanOrEqualTo(form.getMaxSalePrice()))
                .and(hasTourStatusIs(form.getTourStatus()));
    }

    private static Specification<Tour> hasTourStatusIs(Tour.TourStatus tourStatus) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (tourStatus == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("tourStatus"), tourStatus);
        };
    }


    private static Specification<Tour> hasSalePriceGreaterThanOrEqualTo(Double minSalePrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (minSalePrice == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("salePrice"), minSalePrice);
        };

    }

    private static Specification<Tour> hasSalePriceLessThanOrEqualTo(Double maxSalePrice) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (maxSalePrice == null) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("salePrice"), maxSalePrice);
        };

    }

    private static Specification<Tour> hasLocationLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("location"), "%" + search.trim() + "%");
        };

    }

    private static Specification<Tour> hasStartDestinationLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("startDestination"), "%" + search.trim() + "%");
        };

    }

    private static Specification<Tour> hasStartDateGreaterThanEqualTo(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (startDate == null) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("startDate").as(LocalDate.class), startDate);
        };
    }

    private static Specification<Tour> hasDurationGreaterThanEqualTo(int duration) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("duration"), duration);
        };
    }


    private static Specification<Tour> hasTourCodeIs(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("tourCode"), "%" + search.trim() + "%");
        };
    }

    private static Specification<Tour> hasTourNameLike(String search) {
        return  (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("tourName"), "%" + search.trim() + "%");
        };
    }
}
