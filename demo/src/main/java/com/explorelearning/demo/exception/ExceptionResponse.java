package com.explorelearning.demo.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/** 
     * Getter method for timestamp
     * @param None
     * @return Date
     */
	public Date getTimestamp() {
		return timestamp;
	}

	/** 
     * Getter method for message 
     * @param None
     * @return String
     */
	public String getMessage() {
		return message;
	}

	/** 
     * Getter method for details
     * @param Node
     * @return String
     */
	public String getDetails() {
		return details;
	}

}
