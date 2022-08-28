package com.bug.backend.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * BugDTO
 */

@JsonTypeName("Bug")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-31T22:46:54.166885+02:00[Europe/Berlin]")
@NoArgsConstructor
public class BugDTO {

  @JsonProperty("bugId")
  private Long bugId;

  @JsonProperty("description")
  private String description;

  @JsonProperty("topic")
  private String topic;

  @JsonProperty("assignee")
  private PersonDTO assignee;

  @JsonProperty("reporter")
  private PersonDTO reporter;

  /**
   * The states which are defined for an bug
   */
  public enum StateEnum {
    NEW("NEW"),

    IN_PROGRESS("IN-PROGRESS"),

    IN_REVIEW("IN-REVIEW"),

    DONE("DONE");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("state")
  private StateEnum state;

  @JsonProperty("created")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime created;

  @JsonProperty("updated")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updated;

  @JsonProperty("assignees")
  @Valid
  private List<PersonDTO> assignees = null;

  public BugDTO bugId(Long bugId) {
    this.bugId = bugId;
    return this;
  }

  /**
   * Get bugId
   *
   * @return bugId
   */

  @Schema(name = "bugId", example = "1", required = false)
  public Long getBugId() {
    return bugId;
  }

  public void setBugId(Long bugId) {
    this.bugId = bugId;
  }

  public BugDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   *
   * @return description
   */
  @NotNull
  @Schema(name = "description", example = "some description related to the bug", required = true)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BugDTO topic(String topic) {
    this.topic = topic;
    return this;
  }

  /**
   * Get topic
   *
   * @return topic
   */
  @NotNull
  @Schema(name = "topic", example = "a topic", required = true)
  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public BugDTO assignee(PersonDTO assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * Get assignee
   *
   * @return assignee
   */
  @Valid
  @Schema(name = "assignee", required = false)
  public PersonDTO getAssignee() {
    return assignee;
  }

  public void setAssignee(PersonDTO assignee) {
    this.assignee = assignee;
  }

  public BugDTO reporter(PersonDTO reporter) {
    this.reporter = reporter;
    return this;
  }

  /**
   * Get reporter
   *
   * @return reporter
   */
  @NotNull
  @Valid
  @Schema(name = "reporter", required = true)
  public PersonDTO getReporter() {
    return reporter;
  }

  public void setReporter(PersonDTO reporter) {
    this.reporter = reporter;
  }

  public BugDTO state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * The states which are defined for an bug
   *
   * @return state
   */

  @Schema(name = "state", example = "NEW", description = "The states which are defined for an bug", required = false)
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public BugDTO created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * The created timestamp
   *
   * @return created
   */
  @Valid
  @Schema(name = "created", example = "2022-07-27T08:00Z", description = "The created timestamp", required = false)
  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public BugDTO updated(LocalDateTime updated) {
    this.updated = updated;
    return this;
  }

  /**
   * The updated timestamp
   *
   * @return updated
   */
  @Valid
  @Schema(name = "updated", example = "2022-07-27T08:00Z", description = "The updated timestamp", required = false)
  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public BugDTO assignees(List<PersonDTO> assignees) {
    this.assignees = assignees;
    return this;
  }

  public BugDTO addAssigneesItem(PersonDTO assigneesItem) {
    if (this.assignees == null) {
      this.assignees = new ArrayList<>();
    }
    this.assignees.add(assigneesItem);
    return this;
  }

  /**
   * Get assignees
   *
   * @return assignees
   */
  @Valid
  @Schema(name = "assignees", required = false)
  public List<PersonDTO> getAssignees() {
    return assignees;
  }

  public void setAssignees(List<PersonDTO> assignees) {
    this.assignees = assignees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BugDTO bug = (BugDTO) o;
    return Objects.equals(this.bugId, bug.bugId) &&
        Objects.equals(this.description, bug.description) &&
        Objects.equals(this.topic, bug.topic) &&
        Objects.equals(this.assignee, bug.assignee) &&
        Objects.equals(this.reporter, bug.reporter) &&
        Objects.equals(this.state, bug.state) &&
        Objects.equals(this.created, bug.created) &&
        Objects.equals(this.updated, bug.updated) &&
        Objects.equals(this.assignees, bug.assignees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bugId, description, topic, assignee, reporter, state, created, updated,
        assignees);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BugDTO {\n");
    sb.append("    bugId: ").append(toIndentedString(bugId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
    sb.append("    reporter: ").append(toIndentedString(reporter)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    assignees: ").append(toIndentedString(assignees)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

