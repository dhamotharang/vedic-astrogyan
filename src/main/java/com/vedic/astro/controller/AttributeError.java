package com.vedic.astro.controller;

public class AttributeError {

	private String attribute;

	private String message;

	public AttributeError() {
	}

	public AttributeError(String attribute, String message) {
		this.attribute = attribute;
		this.message = message;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AttributeError [attribute=" + attribute + ", message="
				+ message + "]";
	}
}
