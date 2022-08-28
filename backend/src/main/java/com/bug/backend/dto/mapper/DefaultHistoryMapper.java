package com.bug.backend.dto.mapper;

import com.bug.backend.dto.HistoryDTO;
import com.bug.backend.entity.History;
import org.springframework.stereotype.Service;

@Service
public class DefaultHistoryMapper implements HistoryMapper {


  BugMapper bugMapper;

  public DefaultHistoryMapper(BugMapper bugMapper) {
    this.bugMapper = bugMapper;
  }

  @Override
  public HistoryDTO toHistoryDTO(History history) {
    return HistoryDTO.builder().bug(bugMapper.toBugDTO(history.getBug()))
        .oldValue(history.getOldValue()).newValue(history.getNewValue())
        .updated(history.getUpdated()).build();
  }
}
