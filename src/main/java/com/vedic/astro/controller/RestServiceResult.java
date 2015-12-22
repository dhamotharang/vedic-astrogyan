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
	private RestServiceStatus status = RestServiceStatus.SUCCESS;
	
	/**
	 * Reason of failure of RESTFul call.
	 */
    private RestServiceFailureReason failureReason = null;
    
    /**
     * Response data. Set by the definition of the RestServiceResult.
     */
    private T data = null;
    
	public RestServiceStatus getStatus() {
		return status;
	}
	public void setStatus(RestServiceStatus status) {
		this.status = status;
	}
	public RestServiceFailureReason getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(RestServiceFailureReason failureReason) {
		this.failureReason = failureReason;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestServiceResult [status=" + status + ", failureReason="
				+ failureReason + ", data=" + data + "]";
	}
    
}
