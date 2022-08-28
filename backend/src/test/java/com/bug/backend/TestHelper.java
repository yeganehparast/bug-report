package com.bug.backend;

import com.bug.backend.dto.BugDTO;
import com.bug.backend.dto.BugDTO.StateEnum;
import com.bug.backend.dto.PersonDTO;
import com.bug.backend.entity.Bug;
import com.bug.backend.entity.BugState;
import com.bug.backend.entity.Person;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TestHelper {

  public static Bug creatxeBug() {
    Bug bug = new Bug();
    bug.setBugId(null);
    bug.setCreated(LocalDateTime.now());
    bug.setDescription("some description");
    bug.setUpdated(LocalDateTime.now());
    bug.setTopic("test");
    bug.setState(BugState.NEW);
    Person person = new Person();
    person.setId(null);
    person.setEmail("joe@example.com");
    person.setFullName("joe");
    bug.setReporter(person);
    bug.setAssignees(Set.of(person));
    bug.setCurrentAssignee(person);
    return bug;
  }

  public static Bug createBug(boolean fillId) {
    Bug bug = new Bug();
    bug.setBugId(fillId ? 1L : null);
    bug.setCreated(LocalDateTime.now());
    bug.setDescription("some description");
    bug.setUpdated(LocalDateTime.now());
    bug.setTopic("test");
    bug.setState(BugState.NEW);
    Person person = new Person();
    person.setId(fillId ? 1L : null);
    person.setEmail("joe@example.com");
    person.setFullName("joe");
    bug.setReporter(person);
    bug.setAssignees(Set.of(person));
    bug.setCurrentAssignee(person);
    return bug;
  }

  public static BugDTO createBugDTO() {
    PersonDTO personDTO = createPersonDTO();
    BugDTO bugDTO = new BugDTO();
    return bugDTO.bugId(null).created(LocalDateTime.now())
        .description("some description")
        .updated(LocalDateTime.now())
        .topic("test")
        .state(StateEnum.NEW)
        .reporter(personDTO)
        .assignees(List.of(personDTO))
        .assignee(personDTO);
  }

  public static Person createPerson() {
    Person person = new Person();
    person.setId(null);
    person.setFullName("mehdi");
    person.setEmail("mehdi@email.com");
    return person;
  }

  public static PersonDTO createPersonDTO() {
    return new PersonDTO()
        .email("joe@example.com")
        .fullName("joe");
  }
}
