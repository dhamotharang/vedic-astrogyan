package com.vedic.astro.vo;

import com.vedic.astro.enums.Gender;

public class PersonalInfo {
	
	private String pid = null;
	
	private String firstName = null;
	
	private String lastName = null;
	
	private Gender gender = null;
	
	private String dob = null;
	
	private String tob = null;
	
	private String cityCode = null;
	
	private String countryCode = null;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTob() {
		return tob;
	}

	public void setTob(String tob) {
		this.tob = tob;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "PersonalInfo [pid=" + pid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", tob=" + tob + ", cityCode=" + cityCode
				+ ", countryCode=" + countryCode + "]";
	}
}
