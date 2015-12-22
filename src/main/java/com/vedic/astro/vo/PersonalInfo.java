package com.vedic.astro.vo;

import java.util.Date;
import java.util.UUID;

import com.vedic.astro.domain.BirthPlanetaryPositions;
import com.vedic.astro.enums.Gender;

public class PersonalInfo {
	
	private String pid = null;
	
	private String firstName = null;
	
	private String lastName = null;
	
	private Gender gender = null;
	
	private String dob = null;
	
	private BirthPlanetaryPositions birthPlanetaryPositions = null;

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

	public BirthPlanetaryPositions getBirthPlanetaryPositions() {
		return birthPlanetaryPositions;
	}

	public void setBirthPlanetaryPositions(
			BirthPlanetaryPositions birthPlanetaryPositions) {
		this.birthPlanetaryPositions = birthPlanetaryPositions;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "PersonalInfo [pid=" + pid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", birthPlanetaryPositions=" + birthPlanetaryPositions
				+ "]";
	}
}
