package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidLoanAmountException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidAmount(InvalidLoanAmountException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(DuplicateLoanApplicationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleDuplicateBooking(DuplicateLoanApplicationException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.toString());
	}
	
	@ExceptionHandler(LoanNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotFound(LoanNotFoundException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(Exception ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
}
