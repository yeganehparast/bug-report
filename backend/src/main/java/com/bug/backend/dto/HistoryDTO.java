package com.bug.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.annotation.Generated;
import javax.validation.Valid;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * HistoryDTO
 */

@JsonTypeName("History")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-02T12:19:00.184313+02:00[Europe/Berlin]")
@Builder
public class HistoryDTO {

  @JsonProperty("bug")
  private BugDTO bug;

  @JsonProperty("newValue")
  private String newValue;

  @JsonProperty("oldValue")
  private String oldValue;

  @JsonProperty("updated")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updated;

  public HistoryDTO bug(BugDTO bug) {
    this.bug = bug;
    return this;
  }

  /**
   * Get bug
   *
   * @return bug
   */
  @Valid
  @Schema(name = "bug", required = false)
  public BugDTO getBug() {
    return bug;
  }

  public void setBug(BugDTO bug) {
    this.bug = bug;
  }

  public HistoryDTO newValue(String newValue) {
    this.newValue = newValue;
    return this;
  }

  /**
   * new stroed value
   *
   * @return newValue
   */

  @Schema(name = "newValue", description = "new stroed value", required = false)
  public String getNewValue() {
    return newValue;
  }

  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  public HistoryDTO oldValue(String oldValue) {
    this.oldValue = oldValue;
    return this;
  }

  /**
   * old stored value
   *
   * @return oldValue
   */

  @Schema(name = "oldValue", description = "old stored value", required = false)
  public String getOldValue() {
    return oldValue;
  }

  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }

  public HistoryDTO updated(LocalDateTime updated) {
    this.updated = updated;
    return this;
  }

  /**
   * time of update
   *
   * @return updated
   */
  @Valid
  @Schema(name = "updated", description = "time of update", required = false)
  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoryDTO history = (HistoryDTO) o;
    return Objects.equals(this.bug, history.bug) &&
        Objects.equals(this.newValue, history.newValue) &&
        Objects.equals(this.oldValue, history.oldValue) &&
        Objects.equals(this.updated, history.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bug, newValue, oldValue, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoryDTO {\n");
    sb.append("    bug: ").append(toIndentedString(bug)).append("\n");
    sb.append("    newValue: ").append(toIndentedString(newValue)).append("\n");
    sb.append("    oldValue: ").append(toIndentedString(oldValue)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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

