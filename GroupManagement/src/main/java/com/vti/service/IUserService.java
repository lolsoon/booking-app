package com.vti.service;

import com.vti.entity.ERole;
import com.vti.form.AuthChangePasswordForm;
import com.vti.form.UserFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vti.dto.ChangePublicProfileDTO;
import com.vti.entity.User;

import java.util.List;

public interface IUserService extends UserDetailsService {

	Page<User> findAll(Pageable pageable, UserFilterForm form);

	void createUser(User user);

	User findUserByEmail(String email);

	User findUserByUserName(String userName);

	void activeUser(String token);

	void sendConfirmUserRegistrationViaEmail(String email);

	boolean existsUserByEmail(String email);

	boolean existsUserByUserName(String userName);

	void resetPasswordViaEmail(String email);

	void resetPassword(String token, String newPassword);

	void sendResetPasswordViaEmail(String email);

	UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
	
	void changeUserProfile(String userName, ChangePublicProfileDTO dto);

//	List<User> findUsersByRole(String role);
}
