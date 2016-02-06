package com.vedic.astro.dto;

import com.vedic.astro.enums.UserRole;

public class UserDTO {
	
	private String firstName = null;
	
	private String lastName = null;
	
	private UserRole role = null;
	
	private String lastViewedPid = null;

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

	public String getLastViewedPid() {
		return lastViewedPid;
	}

	public void setLastViewedPid(String lastViewedPid) {
		this.lastViewedPid = lastViewedPid;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", lastViewedPid="
				+ lastViewedPid + "]";
	}
}