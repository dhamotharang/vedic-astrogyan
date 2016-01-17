package com.vedic.astro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="location_info")
public class LocationInfo {
	
	@Id
	private String id;
	private String countryCode;
	private String cityCode;
	private Integer locationId;

	public LocationInfo(String countryCode, String cityCode, Integer locationId) {
		super();
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.locationId = locationId;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "LocationInfo [countryCode=" + countryCode + ", cityCode=" + cityCode + ", locationId=" + locationId
				+ "]";
	}
}
