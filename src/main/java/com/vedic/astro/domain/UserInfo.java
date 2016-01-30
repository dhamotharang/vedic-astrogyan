package com.vedic.astro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.UserRole;

@Document(collection="app_users")
@TypeAlias("user_info")
public class UserInfo {
	
	@Id
	private String id = null;
	
	private String firstName = null;
	
	private String lastName = null;
	
	@Indexed(unique=true, dropDups=true) 
	private String email = null;
	
	private String password = null;
	
	private UserRole role = null;
	
	private boolean loggedIn = false;
	
	private Date lastLoginTS = null;
	
	private String lastViewedPid = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Date getLastLoginTS() {
		return lastLoginTS;
	}

	public void setLastLoginTS(Date lastLoginTS) {
		this.lastLoginTS = lastLoginTS;
	}

	public String getLastViewedPid() {
		return lastViewedPid;
	}

	public void setLastViewedPid(String lastViewedPid) {
		this.lastViewedPid = lastViewedPid;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", loggedIn=" + loggedIn + ", lastLoginTS="
				+ lastLoginTS + ", lastViewedPid=" + lastViewedPid + "]";
	}
}