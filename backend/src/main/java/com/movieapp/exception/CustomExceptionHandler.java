package com.movieapp.exception;
 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
 
	 @ExceptionHandler(MovieBookingException.class)
    public ResponseEntity<Object> handleMovieBookingException(MovieBookingException ex, WebRequest request) {
		 String bodyOfResponse = "Internalerror occured during.Please contact support.";
	     return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}