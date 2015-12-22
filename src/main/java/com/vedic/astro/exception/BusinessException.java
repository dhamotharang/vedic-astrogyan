package com.vedic.astro.exception;

/**
 * Business Exception for validation messages.
 * 
 * @author Sumeer Saxena
 *
 */
public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1086065403106687362L;

	/**
	 * Error code of the exception
	 */
	private String errorCode;
	
	/**
	 * Error message of the exception
	 */
	private String errorMessage;

	public BusinessException(String errorCode, String errorMessage){
          this.errorCode = errorCode;
          this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


}
