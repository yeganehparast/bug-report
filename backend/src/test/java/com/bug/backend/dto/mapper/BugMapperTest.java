package com.bug.backend.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bug.backend.TestHelper;
import com.bug.backend.dto.BugDTO;
import com.bug.backend.entity.Bug;
import com.bug.backend.entity.Person;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class BugMapperTest {

  DefaultPersonMapper defaultPersonMapper = new DefaultPersonMapper();
  DefaultBugMapper bugMapper = new DefaultBugMapper(defaultPersonMapper);

  @Test
  void testToBugDTO() {
    Bug bug = TestHelper.createBug(false);
    BugDTO bugDTO = bugMapper.toBugDTO(bug);

    assertEquals(bugDTO.getBugId(), bug.getBugId());
    assertEquals(bugDTO.getDescription(), bug.getDescription());
    assertEquals(bugDTO.getState().getValue(), bug.getState().getValue());
    assertEquals(bugDTO.getTopic(), bug.getTopic());
    assertEquals(bugDTO.getCreated(), bug.getCreated());
    assertEquals(bugDTO.getUpdated(), bug.getUpdated());
    assertEquals(bugDTO.getReporter().getEmail(), bug.getReporter().getEmail());
    assertEquals(bugDTO.getReporter().getFullName(), bug.getReporter().getFullName());
    assertEquals(bugDTO.getAssignee().getFullName(), bug.getCurrentAssignee().getFullName());
    assertEquals(bugDTO.getAssignee().getEmail(), bug.getCurrentAssignee().getEmail());
    bugDTO.getAssignees().forEach(p -> {
      Optional<Person> anyDTO = bug.getAssignees().stream()
          .filter(person -> p.getEmail().equals(person.getEmail())).filter(
              person -> p.getFullName().equals(person.getFullName())).findAny();
      assertTrue(anyDTO.isPresent());
    });

  }

  @Test
  void testMapper() {
    Bug bug = TestHelper.createBug(false);
    BugDTO bugDTO = bugMapper.toBugDTO(bug);
    checkObjects(bugDTO, bug);

    Bug bugMapped = bugMapper.toBug(bugDTO);

    assertEquals(bugMapped, bug);
  }

  private void checkObjects(BugDTO bugDTO, Bug bug) {
    assertEquals(bugDTO.getBugId(), bug.getBugId());
    assertEquals(bugDTO.getDescription(), bug.getDescription());
    assertEquals(bugDTO.getState().getValue(), bug.getState().getValue());
    assertEquals(bugDTO.getTopic(), bug.getTopic());
    assertEquals(bugDTO.getCreated(), bug.getCreated());
    assertEquals(bugDTO.getUpdated(), bug.getUpdated());
    assertEquals(bugDTO.getReporter().getEmail(), bug.getReporter().getEmail());
    assertEquals(bugDTO.getReporter().getFullName(), bug.getReporter().getFullName());
    assertEquals(bugDTO.getAssignee().getFullName(), bug.getCurrentAssignee().getFullName());
    assertEquals(bugDTO.getAssignee().getEmail(), bug.getCurrentAssignee().getEmail());
    bugDTO.getAssignees().forEach(p -> {
      Optional<Person> anyDTO = bug.getAssignees().stream()
          .filter(person -> p.getEmail().equals(person.getEmail())).filter(
              person -> p.getFullName().equals(person.getFullName())).findAny();
      assertTrue(anyDTO.isPresent());
    });
  }

}
