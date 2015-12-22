package com.vedic.astro.vo;

import com.vedic.astro.domain.SunriseSunsetData;
import com.vedic.astro.enums.Gender;

public class PersonalBirthInfo {
	
	private String pid = null;
	
	private String firstName = null;
	
	private String lastName = null;
	
	private Gender gender = null;
	
	private String dob = null;
	
	private String tob = null;
	
	private Integer locationId = null;
	
	private SunriseSunsetData sunriseSunsetData = null;

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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTob() {
		return tob;
	}

	public void setTob(String tob) {
		this.tob = tob;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public SunriseSunsetData getSunriseSunsetData() {
		return sunriseSunsetData;
	}

	public void setSunriseSunsetData(SunriseSunsetData sunriseSunsetData) {
		this.sunriseSunsetData = sunriseSunsetData;
	}

	@Override
	public String toString() {
		return "PersonalBirthInfo [pid=" + pid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", tob=" + tob + ", locationId=" + locationId
				+ ", sunriseSunsetData=" + sunriseSunsetData + "]";
	}
}
