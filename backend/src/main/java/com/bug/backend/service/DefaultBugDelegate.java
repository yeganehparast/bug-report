package com.bug.backend.service;

import com.bug.backend.api.BugApiDelegate;
import com.bug.backend.dto.BugDTO;
import com.bug.backend.dto.HistoryDTO;
import com.bug.backend.dto.mapper.BugMapper;
import com.bug.backend.dto.mapper.HistoryMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DefaultBugDelegate implements BugApiDelegate {

  BugMapper bugMapper;

  HistoryMapper historyMapper;
  DefaultBugService bugService;

  public DefaultBugDelegate(BugMapper bugMapper, HistoryMapper historyMapper,
      DefaultBugService bugService) {
    this.bugMapper = bugMapper;
    this.historyMapper = historyMapper;
    this.bugService = bugService;
  }

  @Override
  public ResponseEntity<BugDTO> createBug(BugDTO bugDTO) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(bugMapper.toBugDTO(bugService.save(bugMapper.toBug(bugDTO))));
  }

  @Override
  public ResponseEntity<List<BugDTO>> getBugByAssignee(String assigneeName) {
    return ResponseEntity.ok(
        bugService.findBugsByCurrentAssignee(assigneeName).stream().map(bugMapper::toBugDTO)
            .collect(Collectors.toUnmodifiableList()));
  }

  @Override
  public ResponseEntity<List<BugDTO>> getBugByReporter(String reporterName) {
    return ResponseEntity.ok(
        bugService.findBugsByReporter(reporterName).stream().map(bugMapper::toBugDTO)
            .collect(Collectors.toUnmodifiableList()));
  }

  @Override
  public ResponseEntity<Void> deleteBug(Long body) {
    bugService.delete(body);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @Override
  public ResponseEntity<BugDTO> getBugById(Long bugId) {
    return ResponseEntity.ok(bugMapper.toBugDTO(bugService.findBugById(bugId)));
  }

  @Override
  public ResponseEntity<List<BugDTO>> getBugByState(String state) {
    return ResponseEntity.ok(
        bugService.findBugsByState(state).stream().map(bugMapper::toBugDTO)
            .collect(Collectors.toUnmodifiableList()));
  }

  @Override
  public ResponseEntity<List<BugDTO>> listBugs() {
    return ResponseEntity.ok(
        bugService.findAllBugs().stream().map(bugMapper::toBugDTO)
            .collect(Collectors.toUnmodifiableList()));
  }

  @Override
  public ResponseEntity<List<BugDTO>> getBugByTopic(String topic) {
    return ResponseEntity.ok(
        bugService.findBugsByTopic(topic).stream().map(bugMapper::toBugDTO)
            .collect(Collectors.toUnmodifiableList()));
  }

  @Override
  public ResponseEntity<BugDTO> updateBug(BugDTO bugBody) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(bugMapper.toBugDTO(bugService.update(bugMapper.toBug(bugBody))));
  }

  @Override
  public ResponseEntity<List<HistoryDTO>> getBugHistory(Long bugId) {
    return ResponseEntity.ok(
        bugService.findHistoriesByBugId(bugId).stream().map(historyMapper::toHistoryDTO).collect(
            Collectors.toUnmodifiableList()));
  }
}
