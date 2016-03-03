package com.vedic.astro.dto;

import com.vedic.astro.enums.UserRole;

public class UserDTO {
	
	private String firstName = null;
	private String lastName = null;
	private UserRole role = null;
	private String lastViewedPid = null;
	private String id = null;
	private String contact = null;
	private String blocked = "N";
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBlocked() {
		return blocked;
	}
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", lastViewedPid="
				+ lastViewedPid + ", id=" + id + ", contact=" + contact + ", blocked=" + blocked + "]";
	}
}