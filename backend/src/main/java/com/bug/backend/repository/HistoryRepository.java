package com.bug.backend.repository;

import com.bug.backend.entity.History;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

  List<History> findAllByBugBugId(Long is);
}
