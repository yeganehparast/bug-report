package com.bug.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends NullPointerException {

  public InvalidInputException(String message) {
    super(message);
  }
}
