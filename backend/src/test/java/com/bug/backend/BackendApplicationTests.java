package com.bug.backend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bug.backend.api.BugApiController;
import com.bug.backend.configuration.BugControllerAdvice;
import com.bug.backend.dto.BugDTO;
import com.bug.backend.dto.mapper.BugMapper;
import com.bug.backend.dto.mapper.HistoryMapper;
import com.bug.backend.exception.BugNotFoundException;
import com.bug.backend.exception.InvalidInputException;
import com.bug.backend.service.DefaultBugDelegate;
import com.bug.backend.service.DefaultBugService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class BackendApplicationTests {

  MockMvc mockMvc;
  DefaultBugService bugService;

  WebApplicationContext applicationContext;

  ObjectMapper mapper;
  BugMapper bugMapper;
  HistoryMapper historyMapper;

  @Autowired
  public BackendApplicationTests(DefaultBugService bugService,
      WebApplicationContext webApplicationContext, BugMapper bugMapper,
      HistoryMapper historyMapper) {
    this.bugService = bugService;
    this.bugMapper = bugMapper;
    this.historyMapper = historyMapper;
    this.mapper = new ObjectMapper();
    this.applicationContext = webApplicationContext;
  }


  @BeforeEach
  void setUp() {
    mapper.registerModule(new JavaTimeModule());
    this.mockMvc = MockMvcBuilders.standaloneSetup(
            new BugApiController(new DefaultBugDelegate(bugMapper, historyMapper, bugService)))
        .setControllerAdvice(BugControllerAdvice.class).build();
    //this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();

  }

  @Test
  void testCreateHappy() throws Exception {

    mockMvc.perform(
            post("/v1/bug").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(TestHelper.createBugDTO())))
        .andDo(print()).andExpect(status().isCreated())
        .andExpect(jsonPath("$.topic").value("test"));
  }

  @Test
  void testCreateUnhappy() throws Exception {
    BugDTO bugDTO = TestHelper.createBugDTO();
    bugDTO.setReporter(null);

    mockMvc.perform(
            post("/v1/bug").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(bugDTO)))
        .andDo(print()).andExpect(status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.message",
            Matchers.containsString("reporter:must not be null")))
        .andExpect(
            result -> assertTrue(result.getResolvedException() instanceof InvalidInputException));
  }

  @Test
  @DisplayName("Test find a bug by assignee full name is blank - Unhappy")
  void testFindBugByAssigneeFullNameIsBlank() throws Exception {
    mockMvc.perform(
            get("/v1/bug/assignee/ ").contentType(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isNotFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.message",
            Matchers.containsString("Bug cannot be found")))
        .andExpect(
            result -> assertTrue(result.getResolvedException() instanceof BugNotFoundException));
  }

  @Test
  @DisplayName("Test find a bug by reporter full name is blank - Unhappy")
  void testFindBugByReporterFullNameIsNull() throws Exception {
    mockMvc.perform(
            get("/v1/bug/reporter/ ").contentType(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isNotFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.message",
            Matchers.containsString("Bug cannot be found")))
        .andExpect(
            result -> assertTrue(result.getResolvedException() instanceof BugNotFoundException));
  }

  @Test
  @DisplayName("Test insert a bug  when topic is null- Unhappy")
  void testPersistWhenTopicIsNull() throws Exception {
    //When
    BugDTO bugDTO = TestHelper.createBugDTO();
    bugDTO.setTopic(null);

    mockMvc.perform(
            post("/v1/bug").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(bugDTO)))
        .andDo(print()).andExpect(status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.message",
            Matchers.containsString("topic:must not be null")))
        .andExpect(
            result -> assertTrue(result.getResolvedException() instanceof InvalidInputException));
  }

}
