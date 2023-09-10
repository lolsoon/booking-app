package com.vti.specification;

import com.vti.entity.User;
import com.vti.entity.ERole;
import com.vti.form.UserFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class UserSpecification {
    public static Specification<User> buildWhere(UserFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasUserNameLike(form.getSearch())
                .or(hasFirstNameLike(form.getSearch()))
                .or(hasLastNameLike(form.getSearch()))
                .or(hasEmailLike(form.getEmail()))
                .and(hasRoleEqual(form.getRole()));
    }

    private static Specification<User> hasRoleEqual(ERole role) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (role == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("role"), role);
        };
    }

    private static Specification<User> hasEmailLike(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(email)) {
                return null;
            }
            return criteriaBuilder.like(root.get("email"), "%" + email.trim() + "%");
        };
    }

    public static Specification<User> hasUserNameLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("userName"), "%" + search.trim() + "%");
        };
    }

    public static Specification<User> hasFirstNameLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("firstName"), "%" + search.trim() + "%");
        };
    }

    public static Specification<User> hasLastNameLike(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.hasText(search)) {
                return null;
            }
            return criteriaBuilder.like(root.get("lastName"), "%" + search.trim() + "%");
        };
    }
}