package com.bug.backend.dto.mapper;

import com.bug.backend.dto.PersonDTO;
import com.bug.backend.entity.Person;

public interface PersonMapper {

  PersonDTO toPersonDTO(Person person);

  Person toPerson(PersonDTO personDTO);

}
