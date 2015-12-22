package com.vedic.astro.domain;


public class Longitude {

	private int degrees;
	private int minutes;
	private int seconds;
	
	public Longitude(int degrees, int minutes, int seconds){
		
		validate(degrees, minutes, seconds);
		
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	protected void validate(int degrees, int minutes, int seconds){
		
		if(minutes > 59 || minutes <0){
			throw new IllegalArgumentException("minutes is between 0 and 60");
		}

		if(seconds > 59 || seconds <0){
			throw new IllegalArgumentException("seconds is between 0 and 60");
		}
	}

	public Longitude(String longitude){
		
		int degreesIndex = longitude.indexOf("*");
		int minutesIndex = longitude.indexOf("'");
		int secondsIndex = longitude.indexOf("''");
		
		this.degrees = Integer.valueOf(longitude.substring(0, degreesIndex));
		this.minutes = Integer.valueOf(longitude.substring(degreesIndex+1, minutesIndex));
		this.seconds = Integer.valueOf(longitude.substring(minutesIndex+1, secondsIndex));
		
		validate(degrees, minutes, seconds);
		
	}
	
	public int getDegrees() {
		return degrees;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	@Override
	public String toString() {
		return "Longitude [degrees=" + degrees + ", minutes=" + minutes
				+ ", seconds=" + seconds + "]";
	}
	
	public static void main(String args[]){
		Longitude longitude = new Longitude("27*55'45''");
	}
	
}
