package com.example1.InterfaceExample.exception;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.fasterxml.jackson.annotation.JsonFormat;

@ControllerAdvice

public class ProductIdInvalidException extends RuntimeException{
	
	LocalDateTime localdatetime;
	String path;
	String type;
	
	public ProductIdInvalidException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductIdInvalidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ProductIdInvalidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ProductIdInvalidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ProductIdInvalidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public ProductIdInvalidException(LocalDateTime localdatetime, String path, String type) {
		super();
		this.localdatetime = localdatetime;
		this.path = path;
		this.type = type;
	}
	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}
	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductIdInvalidException [localdatetime=" + localdatetime + ", path=" + path + ", type=" + type + "]";
	}
	
	
}
