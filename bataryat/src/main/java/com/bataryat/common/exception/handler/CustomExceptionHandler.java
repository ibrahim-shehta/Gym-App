package com.bataryat.common.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.exception.exceptions.EnityNotFoundException;
import com.bataryat.common.exception.model.AppError;
import com.bataryat.common.exception.model.AppSubError;
import com.bataryat.common.exception.model.AppValidationError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;
	
	// my custom exception when find entity by id and not found
	@ExceptionHandler(EnityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EnityNotFoundException ex) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	
	// validation errors 400
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		AppError apiError = new AppError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.VALIDATION_PLAN_NAME,null, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	// any exception in system 500
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		AppError apiError = new AppError(HttpStatus.INTERNAL_SERVER_ERROR);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	// not found 404 
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
	  NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	// not allowed method 405  
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		AppError apiError = new AppError(HttpStatus.METHOD_NOT_ALLOWED);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	
	// validation error or binding errors or method argument not valid 400
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<AppSubError>  appValidationErrors = new ArrayList<>(ex.getAllErrors().size());
		ex.getAllErrors().forEach(item -> {
			FieldError fieldError = (FieldError) item;
			appValidationErrors.add(new AppValidationError(
					fieldError.getObjectName(), 
					fieldError.getField(), 
					fieldError.getRejectedValue(), 
					resourceBundleMessageSource.getMessage(fieldError.getDefaultMessage(), null, LocaleContextHolder.getLocale()))
					);
		});
	    ex.getBindingResult().getAllErrors();
		AppError apiError = new AppError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_DATA_NOT_VALID,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(null);
		apiError.setSubErrors(appValidationErrors)	;
		return buildResponseEntity(apiError);
	}
	    
	    
	   
	
	
	private ResponseEntity<Object> buildResponseEntity(AppError appError) {
		return new ResponseEntity<>(appError, appError.getStatus());
	}
}