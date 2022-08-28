package com.bug.backend.dto.mapper;

import com.bug.backend.dto.HistoryDTO;
import com.bug.backend.entity.History;

public interface HistoryMapper {

  HistoryDTO toHistoryDTO(History history);
}
