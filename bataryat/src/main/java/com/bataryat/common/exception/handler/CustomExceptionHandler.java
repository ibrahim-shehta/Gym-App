package com.bataryat.common.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bataryat.common.constant.MessagesKeys;
import com.bataryat.common.exception.exceptions.EnityNotFoundException;
import com.bataryat.common.exception.model.AppError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;
	
	@ExceptionHandler(EnityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EnityNotFoundException ex) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		AppError apiError = new AppError(HttpStatus.INTERNAL_SERVER_ERROR);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
	  NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		AppError apiError = new AppError(HttpStatus.METHOD_NOT_ALLOWED);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.EXCEPTION_MESSAGES_INTERNAL_SERVER_ERROR,null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(AppError appError) {
		return new ResponseEntity<>(appError, appError.getStatus());
	}
}