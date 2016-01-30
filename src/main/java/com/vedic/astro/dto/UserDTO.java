package com.vedic.astro.dto;

import com.vedic.astro.enums.UserRole;

public class UserDTO {
	
	private String firstName = null;
	
	private String lastName = null;
	
	private UserRole role = null;
	
	private String id = null;
	
	private Boolean loggedIn = false;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", id=" + id
				+ ", loggedIn=" + loggedIn + "]";
	}
}
