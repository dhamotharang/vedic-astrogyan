package com.vedic.astro.dto;

public class UserInfoDTO extends UserDTO {

	private String email = null;
	private String password = null;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [email=" + email + ", password=" + password + "]";
	}
}
