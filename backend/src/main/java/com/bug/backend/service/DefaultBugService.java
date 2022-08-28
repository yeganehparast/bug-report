package com.bug.backend.service;

import com.bug.backend.entity.Bug;
import com.bug.backend.entity.BugState;
import com.bug.backend.entity.History;
import com.bug.backend.entity.Person;
import com.bug.backend.exception.BugNotFoundException;
import com.bug.backend.repository.BugRepository;
import com.bug.backend.repository.HistoryRepository;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultBugService {

  BugRepository bugRepository;

  HistoryRepository historyRepository;

  public DefaultBugService(BugRepository bugRepository, HistoryRepository historyRepository) {
    this.bugRepository = bugRepository;
    this.historyRepository = historyRepository;
  }

  public Bug save(Bug bug) {
    log.debug("SAVE :: {}", bug);

    bug.setState(BugState.NEW);
    bug.setCreated(LocalDateTime.now());
    HashSet<Person> assignees = new HashSet<>();
    if (bug.getAssignees() != null) {
      bug.getAssignees().forEach(p -> assignees.add(p));
    }
    assignees.add(bug.getCurrentAssignee());
    return bugRepository.save(bug);
  }

  @Transactional
  public Bug update(Bug bug) {
    log.debug("UPDATE :: {}", bug);

    Bug foundBug = bugRepository.findBugByBugId(bug.getBugId())
        .orElseThrow(() -> new BugNotFoundException("Bug Not found"));
    Bug old = (Bug) foundBug.clone();

    LocalDateTime now = LocalDateTime.now();
    foundBug.setUpdated(now);
    foundBug.setCurrentAssignee(bug.getCurrentAssignee());
    foundBug.setTopic(bug.getTopic());
    foundBug.setState(bug.getState());
    foundBug.setDescription(bug.getDescription());
    bug.getAssignees().add(bug.getCurrentAssignee());
    foundBug.setAssignees(bug.getAssignees());

    Bug updated = bugRepository.save(foundBug);

    //insert histories
    History history = new History();
    history.setBug(updated);
    history.setField("bug");
    history.setNewValue(updated.toString());
    history.setOldValue(old.toString());
    history.setUpdated(now);
    historyRepository.save(history);

    return updated;
  }

  public void delete(Long id) {
    log.debug("DELETE BUG ID:: {}", id);
    bugRepository.delete(bugRepository.findBugByBugId(id)
        .orElseThrow(() -> new BugNotFoundException("Bug Not found")));
  }

  public List<Bug> findAllBugs() {
    log.debug("FIND ALL BUGS");
    return bugRepository.findAll();
  }

  public Bug findBugById(Long id) {
    log.debug("FIND BUG ID:: {}", id);
    return bugRepository.findBugByBugId(id)
        .orElseThrow(() -> new BugNotFoundException("Bug Not found"));
  }

  public List<Bug> findBugsByTopic(String topic) {
    log.debug("FIND BUG TOPIC:: {}", topic);
    return bugRepository.findAllByTopicLikeIgnoreCase(topic);
  }

  public List<Bug> findBugsByState(String state) {
    log.debug("DELETE BUG STATE:: {}", state);
    return bugRepository.findAllByState(BugState.fromValue(state));
  }

  public List<Bug> findBugsByCurrentAssignee(String fullName) {
    log.debug("FIND BUG CURRENT ASSIGNEE NAME:: {}", fullName);
    List<Bug> list = bugRepository.findAllByCurrentAssigneeFullName(fullName);
    if (list.isEmpty()) {
      throw new BugNotFoundException("bug not found");
    }
    return list;

  }

  public List<Bug> findBugsByReporter(String fullName) {
    log.debug("FIND BUG REPORTER NAME:: {}", fullName);
    List<Bug> list = bugRepository.findAllByReporterFullName(fullName);
    if (list.isEmpty()) {
      throw new BugNotFoundException("bug not found");
    }
    return list;
  }

  public List<History> findHistoriesByBugId(Long id) {
    log.debug("FIND HISTORY BY ID :: {}", id);
    return historyRepository.findAllByBugBugId(id);
  }

}
