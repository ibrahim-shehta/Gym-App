package com.bataryat.common.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bataryat.common.exception.exceptions.EnityNotFoundException;
import com.bataryat.common.exception.model.AppError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;
	
	@ExceptionHandler(EnityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EnityNotFoundException ex) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	
	private ResponseEntity<Object> buildResponseEntity(AppError appError) {
		return new ResponseEntity<>(appError, appError.getStatus());
	}
}