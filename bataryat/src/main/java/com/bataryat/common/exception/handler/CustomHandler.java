package com.bataryat.common.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bataryat.common.exception.model.AppError;

@ControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return buildResponseEntity(new AppError(HttpStatus.BAD_REQUEST, "handleExceptionInternal", ex));
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new AppError(HttpStatus.BAD_REQUEST, "handleHttpMessageNotReadable", ex));
	}

	private ResponseEntity<Object> buildResponseEntity(AppError appError) {
		return new ResponseEntity<>(appError, appError.getStatus());
	}
}