package com.geocode.octowallet.services.exception_handlers;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionHandler
 */
@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<StandardError> entityNotFound(NoSuchElementException e, HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
        "O dado solicitado não pode ser encontrado.", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

}
