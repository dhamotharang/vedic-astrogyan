package com.vedic.astro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.Gender;
import com.vedic.astro.enums.MemberType;

@Document(collection="members")
@TypeAlias("member")
public class Member {
	
	@Id
	private String pid = null;
	private String firstName = null;
	private String lastName = null;
	private Gender gender = null;
	private Date dateOfBirth = null;
	private String cityCode = null;
	private String countryCode = null;
	private String email = null;
	private String contact = null;
	private boolean active = true;
	private Date createdDt = null;
	private Date updatedDt = null;
	private String createdById = null;
	private MemberType memberType = null;
	private SunriseSunsetData sunriseSunset = null;
	
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	
	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	public SunriseSunsetData getSunriseSunset() {
		return sunriseSunset;
	}

	public void setSunriseSunset(SunriseSunsetData sunriseSunset) {
		this.sunriseSunset = sunriseSunset;
	}

	@Override
	public String toString() {
		return "Member [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", cityCode=" + cityCode + ", countryCode=" + countryCode
				+ ", email=" + email + ", contact=" + contact + ", active=" + active + ", createdDt=" + createdDt
				+ ", updatedDt=" + updatedDt + ", createdById=" + createdById + ", memberType=" + memberType
				+ ", sunriseSunset=" + sunriseSunset + "]";
	}
}
