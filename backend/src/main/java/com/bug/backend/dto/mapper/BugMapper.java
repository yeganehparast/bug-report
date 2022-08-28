package com.bug.backend.dto.mapper;

import com.bug.backend.dto.BugDTO;
import com.bug.backend.entity.Bug;


public interface BugMapper {

  BugDTO toBugDTO(Bug bug);

  Bug toBug(BugDTO bugDTO);
}
