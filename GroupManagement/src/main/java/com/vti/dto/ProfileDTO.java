package com.vti.dto;

import com.vti.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ProfileDTO {

	private String userName;

	private String email;

	private String firstName;

	private String lastName;

	private String role;

	private String status;

	private String avatarUrl;

	public ProfileDTO(String userName, String email, String firstName, String lastName, String role, String status,
			String avatarUrl) {
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.status = status;
		this.avatarUrl = avatarUrl;
	}

	public ProfileDTO(String userName, String email, String firstName, String lastName, Set<Role> role, String status, String avatarUrl) {
	}


	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

}
