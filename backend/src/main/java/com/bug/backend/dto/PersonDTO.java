package com.bug.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.annotation.Generated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

/**
 * PersonDTO
 */

@JsonTypeName("Person")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-31T22:46:54.166885+02:00[Europe/Berlin]")
@NoArgsConstructor
public class PersonDTO {

  @JsonProperty("fullName")
  private String fullName;

  @JsonProperty("email")
  private String email;

  public PersonDTO fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * full name
   *
   * @return fullName
   */
  @NotNull
  @Schema(name = "fullName", example = "John Smith", description = "full name", required = true)
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public PersonDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email
   *
   * @return email
   */
  @NotNull
  @Email
  @Schema(name = "email", example = "joe@example.com", description = "email", required = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDTO person = (PersonDTO) o;
    return Objects.equals(this.fullName, person.fullName) &&
        Objects.equals(this.email, person.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonDTO {\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

