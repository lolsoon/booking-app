package com.vti.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AuthChangePasswordForm {
    @NotBlank(message = "{UserForm.username.NotBlank}")
    @Length(max = 50, message = "{UserForm.userName.Length}")
//    @AccountExistsByUsername
    private String userName;

    @NotBlank(message = "{UserForm.password.NotBlank}")
    @Length(max = 32, message = "{UserForm.password.Length}")
    private String password;
}
