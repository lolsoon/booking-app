package com.vti.form;

import com.vti.entity.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFilterForm {
    private String search;
    private ERole role;
    private String email;
}
