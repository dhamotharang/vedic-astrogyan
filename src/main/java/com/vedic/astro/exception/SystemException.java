package com.vedic.astro.exception;

/**
 * Runtime exception thrown when something goes wrong at the system level.
 * 
 * @author Sumeer Saxena
 *
 */
public class SystemException extends RuntimeException {
	
	private static final long serialVersionUID = 1086065403106687362L;

	/**
	 * Custom message for the exception.
	 */
	private String errorMessage;

	public SystemException(String errorMessage, Throwable throwable){
         super(errorMessage,throwable);    
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}


}
