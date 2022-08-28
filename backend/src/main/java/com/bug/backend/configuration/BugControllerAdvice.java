package com.bug.backend.configuration;

import com.bug.backend.dto.ErrorMessageDTO;
import com.bug.backend.exception.BugNotFoundException;
import com.bug.backend.exception.InvalidInputException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BugControllerAdvice {

  @ExceptionHandler(BugNotFoundException.class)
  public ResponseEntity<ErrorMessageDTO> handle(BugNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        ErrorMessageDTO.builder().message("Bug cannot be found")
            .timestamp(LocalDateTime.now())
            .statusCode(HttpStatus.NOT_FOUND.toString()).build());
  }

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<ErrorMessageDTO> handle(InvalidInputException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessageDTO.builder()
        .timestamp(LocalDateTime.now())
        .message(
            String.format("Invalid input caused failure in operation. Mor information is found: %s",
                exception.getMessage()))
        .statusCode(HttpStatus.BAD_REQUEST.toString()).build());
  }

//  @ExceptionHandler(Exception.class)
//  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//  public ResponseEntity<ErrorMessageDTO> handle(Exception exception) {
//    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessageDTO.builder()
//        .timestamp(LocalDateTime.now())
//        .message(String.format("Operation was failed due to %s", exception.toString()))
//        .statusCode(HttpStatus.BAD_REQUEST.toString()).build());
//  }
}
