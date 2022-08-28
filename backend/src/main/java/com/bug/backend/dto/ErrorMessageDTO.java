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
 * ErrorMessageDTO
 */

@JsonTypeName("ErrorMessage")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-01T22:52:35.850435+02:00[Europe/Berlin]")
@Builder
public class ErrorMessageDTO {

  @JsonProperty("statusCode")
  private String statusCode;

  @JsonProperty("message")
  private String message;

  @JsonProperty("timestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime timestamp;

  public ErrorMessageDTO statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   *
   * @return statusCode
   */

  @Schema(name = "statusCode", required = false)
  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public ErrorMessageDTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   *
   * @return message
   */

  @Schema(name = "message", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorMessageDTO timestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   *
   * @return timestamp
   */
  @Valid
  @Schema(name = "timestamp", required = false)
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessageDTO errorMessage = (ErrorMessageDTO) o;
    return Objects.equals(this.statusCode, errorMessage.statusCode) &&
        Objects.equals(this.message, errorMessage.message) &&
        Objects.equals(this.timestamp, errorMessage.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, message, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessageDTO {\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

