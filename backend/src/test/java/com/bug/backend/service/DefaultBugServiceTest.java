package com.bug.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bug.backend.TestHelper;
import com.bug.backend.entity.Bug;
import com.bug.backend.exception.BugNotFoundException;
import com.bug.backend.repository.BugRepository;
import com.bug.backend.repository.HistoryRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultBugServiceTest {

  @InjectMocks
  DefaultBugService defaultBugService;

  @Mock
  BugRepository bugRepository;

  @Mock
  HistoryRepository historyRepository;

  @BeforeEach
  void init() {
    defaultBugService = new DefaultBugService(bugRepository, historyRepository);
  }

  @Test
  @DisplayName("Test insert a bug - Happy")
  void testPersist() {
    //when
    Bug bug = TestHelper.createBug(false);
    when(bugRepository.save(any())).thenReturn(bug);

    //Then
    Bug saved = defaultBugService.save(bug);

    //Verify
    assertThat(saved).isEqualTo(bug);
  }

  @Test
  @DisplayName("Test update when bug is not found- Unhappy")
  void testUpdateWhenBugNotFound() {
    //when
    when(bugRepository.findBugByBugId(anyLong())).thenThrow(BugNotFoundException.class);

    //Then
    assertThrows(BugNotFoundException.class,
        () -> defaultBugService.update(TestHelper.createBug(true)));
    //verify
    verify(bugRepository, never()).save(any());
  }

  @Test
  @DisplayName("Test delete a bug - Happy")
  void testDelete() {
    //when
    Bug bug = TestHelper.createBug(false);
    when(bugRepository.findBugByBugId(anyLong())).thenReturn(Optional.of(bug));

    //Then
    defaultBugService.delete(1l);

    //Verify
    verify(bugRepository, times(1)).delete(bug);
  }

  @Test
  @DisplayName("Test delete when Bug is not found -Unhappy")
  void testDeleteWhenBugNotFound() {
    //when
    when(bugRepository.findBugByBugId(anyLong())).thenThrow(BugNotFoundException.class);

    //Then
    assertThrows(BugNotFoundException.class, () -> defaultBugService.delete(1L));

    //verify
    verify(bugRepository, never()).delete(any());
  }

  @Test
  @DisplayName("Test find a bug by reporter full name - Happy")
  void testFindBugByReporterFullName() {
    //when
    Bug bug = TestHelper.createBug(false);
    when(bugRepository.findAllByReporterFullName(anyString())).thenReturn(List.of(bug));

    //Then
    List<Bug> list = defaultBugService.findBugsByReporter("mehdi");

    //verify
    verify(bugRepository, times(1)).findAllByReporterFullName(anyString());
    assertEquals(List.of(bug), list);
  }

  @Test
  @DisplayName("Test find a bug by assignee full name - Happy")
  void testFindBugByAssigneeFullName() {
    //when
    Bug bug = TestHelper.createBug(false);
    when(bugRepository.findAllByCurrentAssigneeFullName(anyString())).thenReturn(List.of(bug));

    //Then
    List<Bug> list = defaultBugService.findBugsByCurrentAssignee("mehdi");

    //verify
    verify(bugRepository, times(1)).findAllByCurrentAssigneeFullName(anyString());
    assertEquals(List.of(bug), list);
  }
}
