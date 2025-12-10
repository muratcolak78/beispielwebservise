package com.allcompare.bingoastradirectwebservice.service.exceptionhandling.handler;

import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<String> handlerBaseException(BaseException exception){
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
