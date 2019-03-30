package com.oxy.utils;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceException extends RuntimeException{
	protected HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	private Integer errorCode;
	public ServiceException(int errorCode, String message){
		super(message);
		this.errorCode = Integer.valueOf(errorCode);
	}
}
