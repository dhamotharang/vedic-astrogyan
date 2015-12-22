package com.vedic.astro.enums;

public enum Weekday {

	Sunday(Planet.SUN,5),Monday(Planet.MON,6),Tuesday(Planet.MAR,0),Wednesday(Planet.MER,1),Thursday(Planet.JUP,2),Friday(Planet.VEN,3),Saturday(Planet.SAT,4);
	
	private Planet owner;
	private int number;

	private Weekday(Planet owner, int number) {
		this.owner = owner;
		this.number = number;
	}

	public Planet getOwner() {
		return owner;
	}

	public void setOwner(Planet owner) {
		this.owner = owner;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static Planet getOwner(int number){
		Planet result = null;
		for(Weekday weekday : Weekday.values()){
			if(weekday.getNumber()==number){
				result = weekday.getOwner();
				break;
			}
		}
		return result;
	}
}
