package com.lopes.cervejaria.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lopes.cervejaria.service.exception.EstiloCadastradoException;

@ControllerAdvice
public class ControllerAdviceEceptionHandler {

	@ExceptionHandler(EstiloCadastradoException.class)
	public ResponseEntity<String> handlerEstiloCadastradoException(EstiloCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());

	}

}
