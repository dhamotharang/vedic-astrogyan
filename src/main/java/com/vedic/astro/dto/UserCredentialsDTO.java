package com.vedic.astro.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCredentialsDTO {
	
	@NotEmpty
	private String email = null;
	
	@NotEmpty
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
		return "UserCredentialsDTO [email=" + email + ", password=" + password + "]";
	}
}
