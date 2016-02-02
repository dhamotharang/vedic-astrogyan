package com.vedic.astro.controller;

/**
 * The response object of the RESTFul web service call which
 * encapsulates the status of the execution of call, data to be returned
 * and reason of failure (in case the execution fails).
 * 
 * @author Sumeer Saxena
 */
public class RestServiceResponse <T> {
	
    /**
     * The status of the response. By default it is SUCCESS.
     */
	private Boolean success = true;
	
	/**
	 * Reason of failure of RESTFul call.
	 */
    private RestServiceFailureReason failureReason = null;
    
    /**
     * Response data. Set by the definition of the RestServiceResult.
     */
    private T responseData = null;
    
    public RestServiceResponse(T responseData) {
		super();
		this.responseData = responseData;
	}
    
    public RestServiceResponse(Boolean success, RestServiceFailureReason failureReason) {
		super();
		this.success = success;
		this.failureReason = failureReason;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
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
		return "RestServiceResponse [success=" + success + ", failureReason=" + failureReason + ", responseData="
				+ responseData + "]";
	}
}
