package com.spacex.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// interceptor - spring component to handle exceptions
@RestControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDto> exceptionHandler(MethodArgumentNotValidException exception) {

		List<FormErrorDto> dto = new ArrayList<>();

		List<FieldError> invalidFields = exception.getBindingResult().getFieldErrors();

		invalidFields.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			FormErrorDto formErrorDto = new FormErrorDto(e.getField(), message);
			dto.add(formErrorDto);
		});

		return dto;

	}
		
}
