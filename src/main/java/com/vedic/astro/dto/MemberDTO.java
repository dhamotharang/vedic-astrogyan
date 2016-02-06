package com.vedic.astro.dto;

import com.vedic.astro.enums.Gender;

public class MemberDTO {
	
	private String firstName = null;
	
	private String lastName = null;
	
	private Gender gender = null;
	
	private String dob = null;
	
	private ReferenceDataDTO city = null;
	
	private ReferenceDataDTO country = null;
	
	private String email = null;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ReferenceDataDTO getCity() {
		return city;
	}

	public void setCity(ReferenceDataDTO city) {
		this.city = city;
	}

	public ReferenceDataDTO getCountry() {
		return country;
	}

	public void setCountry(ReferenceDataDTO country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "MemberDTO [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob
				+ ", city=" + city + ", country=" + country + ", email=" + email + "]";
	}
}
