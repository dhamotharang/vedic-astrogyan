package com.vedic.astro.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * The response object which tells the reason for failure of the RESTFul web
 * service call.
 * 
 * @author Sumeer Saxena
 */
public class RestServiceFailureReason {

	/**
	 * The error code for failure
	 */
	private String errorCode = null;

	/**
	 * The description of the reason of failure.
	 */
	private String errorMessage = null; 
	
	/**
	 * List of error details. 
	 */
	private List<AttributeError> errors = new ArrayList<AttributeError>();

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<AttributeError> getErrors() {
		return errors;
	}

	public void setErrors(List<AttributeError> errors) {
		this.errors = errors;
	}
	
	public void addError(AttributeError error){
		errors.add(error);
	}
	
	public boolean containsErrorOnField(String fieldName){
		
		boolean result = false;
		
		for(AttributeError error : errors){
			if(error.getAttribute().equals(fieldName)){
				result = true;
				break;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "RestServiceFailureReason [errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + ", errors=" + errors + "]";
	}
}
