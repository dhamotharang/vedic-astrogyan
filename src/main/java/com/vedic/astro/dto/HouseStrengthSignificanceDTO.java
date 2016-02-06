package com.vedic.astro.dto;

import com.vedic.astro.enums.House;

public class HouseStrengthSignificanceDTO {
	
	private House house = null;
	private String bodyPart = null;
	private String mental = null;
	private String action = null;
	private String personalityTrait = null;
	private String accumulate = null;
	private String relationship = null;
	
	public HouseStrengthSignificanceDTO(House house, String bodyPart, String mental, String action,
			String personalityTrait, String accumulate, String relationship) {
		this.house = house;
		this.bodyPart = bodyPart;
		this.mental = mental;
		this.action = action;
		this.personalityTrait = personalityTrait;
		this.accumulate = accumulate;
		this.relationship = relationship;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getMental() {
		return mental;
	}

	public void setMental(String mental) {
		this.mental = mental;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPersonalityTrait() {
		return personalityTrait;
	}

	public void setPersonalityTrait(String personalityTrait) {
		this.personalityTrait = personalityTrait;
	}

	public String getAccumulate() {
		return accumulate;
	}

	public void setAccumulate(String accumulate) {
		this.accumulate = accumulate;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "HouseStrengthSignificanceDTO [house=" + house + ", bodyPart=" + bodyPart + ", mental=" + mental
				+ ", action=" + action + ", personalityTrait=" + personalityTrait + ", accumulate=" + accumulate
				+ ", relationship=" + relationship + "]";
	}
}
