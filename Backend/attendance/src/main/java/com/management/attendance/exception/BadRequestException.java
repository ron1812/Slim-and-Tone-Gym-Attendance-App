package com.management.attendance.exception;

/**
 * Bad request exception.
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private String errorCode;

    private String message;

	public BadRequestException() {
		super();
	}
	

	public BadRequestException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(String message) {
		super();
		this.message=message;
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
