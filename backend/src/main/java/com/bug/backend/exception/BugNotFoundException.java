package com.bug.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class
BugNotFoundException extends RuntimeException {

  public BugNotFoundException(String message) {
    super(message);
  }
}
