package com.bug.backend.dto.mapper;

import com.bug.backend.dto.BugDTO;
import com.bug.backend.entity.Bug;
import com.bug.backend.entity.BugState;
import com.bug.backend.entity.Person;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBugMapper implements BugMapper {

  PersonMapper personMapper;

  @Autowired
  public DefaultBugMapper(PersonMapper personMapper) {
    this.personMapper = personMapper;
  }

  @Override
  public BugDTO toBugDTO(Bug bug) {
    BugDTO bugDTO = new BugDTO();
    return bugDTO.bugId(bug.getBugId())
        .state(BugDTO.StateEnum.fromValue(bug.getState().getValue())).topic(bug.getTopic())
        .updated(bug.getUpdated()).created(bug.getCreated())
        .assignee(personMapper.toPersonDTO(bug.getCurrentAssignee()))
        .reporter(personMapper.toPersonDTO(bug.getReporter())).description(bug.getDescription())
        .assignees(bug.getAssignees().stream().map(personMapper::toPersonDTO)
            .collect(Collectors.toUnmodifiableList()))
        ;
  }

  @Override
  public Bug toBug(BugDTO bugDTO) {
    Bug bug = new Bug();
    bug.setBugId(bugDTO.getBugId());
    bug.setTopic(bugDTO.getTopic());
    bug.setState(BugState.fromValue(bugDTO.getState().getValue()));
    bug.setCreated(bugDTO.getCreated());
    bug.setUpdated(bugDTO.getUpdated());
    bug.setCurrentAssignee(personMapper.toPerson(bugDTO.getAssignee()));
    bug.setReporter(personMapper.toPerson(bugDTO.getReporter()));
    bug.setDescription(bugDTO.getDescription());
    if (bugDTO.getAssignees() != null) {
      bug.setAssignees(
          bugDTO.getAssignees().stream().map(personMapper::toPerson).collect(Collectors.toSet()));
    } else {
      bug.setAssignees(new TreeSet<>(Comparator.comparing(Person::getId)));
    }
    return bug;
  }
}
