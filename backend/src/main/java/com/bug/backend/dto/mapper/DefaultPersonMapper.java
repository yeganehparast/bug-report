package com.bug.backend.dto.mapper;

import com.bug.backend.dto.PersonDTO;
import com.bug.backend.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class DefaultPersonMapper implements PersonMapper {

  @Override
  public PersonDTO toPersonDTO(Person person) {
    PersonDTO personDTO = new PersonDTO();
    return personDTO.email(person.getEmail()).fullName(person.getFullName());
  }

  @Override
  public Person toPerson(PersonDTO personDTO) {
    Person person = new Person();
    person.setFullName(personDTO.getFullName());
    person.setEmail(personDTO.getEmail());
    return person;
  }
}
