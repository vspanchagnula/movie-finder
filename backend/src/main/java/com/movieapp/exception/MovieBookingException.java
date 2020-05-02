package com.movieapp.exception;

public class MovieBookingException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public MovieBookingException(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	  }

}
