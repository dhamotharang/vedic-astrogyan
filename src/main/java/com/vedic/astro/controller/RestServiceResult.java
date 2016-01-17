package com.vedic.astro.controller;

/**
 * The response object of the RESTFul web service call which
 * encapsulates the status of the execution of call, data to be returned
 * and reason of failure (in case the execution fails).
 * 
 * @author Sumeer Saxena
 */
public class RestServiceResult <T> {
	
    /**
     * The status of the response. By default it is SUCCESS.
     */
	private RestServiceStatus responseStatus = RestServiceStatus.SUCCESS;
	
	/**
	 * Reason of failure of RESTFul call.
	 */
    private RestServiceFailureReason failureReason = null;
    
    /**
     * Response data. Set by the definition of the RestServiceResult.
     */
    private T responseData = null;
    
    public RestServiceResult(T responseData) {
		super();
		this.responseData = responseData;
	}
    
    public RestServiceResult(RestServiceStatus responseStatus, RestServiceFailureReason failureReason) {
		super();
		this.responseStatus = responseStatus;
		this.failureReason = failureReason;
	}



	public RestServiceStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(RestServiceStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public RestServiceFailureReason getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(RestServiceFailureReason failureReason) {
		this.failureReason = failureReason;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}

	@Override
	public String toString() {
		return "RestServiceResult [responseStatus=" + responseStatus
				+ ", failureReason=" + failureReason + ", responseData="
				+ responseData + "]";
	}
}
