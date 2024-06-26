package com.gym.common.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gym.common.constant.AppConstant;
import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.BusinessException;
import com.gym.common.exception.exceptions.EnityNotFoundException;
import com.gym.common.exception.exceptions.EntityDuplicateAttributes;
import com.gym.common.exception.exceptions.SubscriptionException;
import com.gym.common.exception.model.AppError;
import com.gym.common.exception.model.AppSubError;
import com.gym.common.exception.model.AppValidationError;

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
	
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<Object> handleBusniessException(BusinessException ex) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(SubscriptionException.class)
	protected ResponseEntity<Object> handleSubscriptionException(SubscriptionException ex) {
		AppError apiError = new AppError(ex.isWarning() ? HttpStatus.CONFLICT : HttpStatus.NOT_FOUND);
		final String[] params = new String[]{ex.getDays()};
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(), params, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	}
	
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException ex) {
		AppError apiError = new AppError(HttpStatus.NOT_FOUND);
		apiError.setMessage(resourceBundleMessageSource.getMessage(MessagesKeys.VALIDATION_FILE_LARGE, new String[] {AppConstant.MAX_FILE_SIZE_IN_MEGA}, LocaleContextHolder.getLocale()));
		return buildResponseEntity(apiError);
	  }
	
	@ExceptionHandler(EntityDuplicateAttributes.class)
	protected ResponseEntity<Object> handleEntityDuplicateAttributes(EntityDuplicateAttributes ex) {
		if (ex.getErrors() != null && !ex.getErrors().isEmpty()) {
			ex.getErrors().forEach(error -> {
				AppValidationError validationError = (AppValidationError) error;
				validationError.setMessage(resourceBundleMessageSource.getMessage(validationError.getMessage(),null, LocaleContextHolder.getLocale()));
			});
		}
		AppError apiError = new AppError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(resourceBundleMessageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()));
		apiError.setDebugMessage(null);
		apiError.setSubErrors(ex.getErrors());
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