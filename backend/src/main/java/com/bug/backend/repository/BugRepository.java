package com.bug.backend.repository;

import com.bug.backend.entity.Bug;
import com.bug.backend.entity.BugState;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {

  Optional<Bug> findBugByBugId(Long id);

  List<Bug> findAllByTopicLikeIgnoreCase(String topic);

  List<Bug> findAllByState(BugState state);

  List<Bug> findAllByCurrentAssigneeFullName(String fullName);

  List<Bug> findAllByReporterFullName(String fullName);

}
