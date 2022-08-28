package com.bug.backend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestPersonDTO {

  private static ValidatorFactory validatorFactory;
  private static Validator validator;

  @BeforeAll
  public static void createValidator() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @AfterAll
  static void close() {
    validatorFactory.close();
  }

  @Test
  void testNullEmail() {
    PersonDTO personDTO = new PersonDTO();
    PersonDTO build = personDTO.email(null).fullName("mehdi");
    Set<ConstraintViolation<PersonDTO>> validate = validator.validate(build);
    assertEquals(1, validate.size());
    assertEquals(validate.stream().findFirst().get().getPropertyPath().toString(), "email");
    assertEquals(validate.stream().findFirst().get().getMessage(), "must not be null");
  }

  @Test
  void testNullFullName() {
    PersonDTO build = new PersonDTO().email("mehdi@email.com").fullName(null);
    Set<ConstraintViolation<PersonDTO>> validate = validator.validate(build);
    assertEquals(1, validate.size());
    assertEquals(validate.stream().findFirst().get().getPropertyPath().toString(), "fullName");
    assertEquals(validate.stream().findFirst().get().getMessage(), "must not be null");
  }

  @Test
  void testInvalidEmail() {
    PersonDTO build = new PersonDTO().email("mehdi").fullName("mehdi");
    Set<ConstraintViolation<PersonDTO>> validate = validator.validate(build);
    assertEquals(1, validate.size());
    assertEquals(validate.stream().findFirst().get().getPropertyPath().toString(), "email");
    assertEquals(validate.stream().findFirst().get().getMessage(),
        "must be a well-formed email address");
  }
}
