package com.bug.backend.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Person implements Cloneable {

  @Id
  @GeneratedValue
  @JoinColumn(name = "person_id")
  private Long id;

  @NotNull
  private String fullName;

  @NotNull
  private String email;

  @Override
  public Object clone() {
    Person person = new Person();
    person.setId(this.getId());
    person.setFullName(this.getFullName());
    person.setEmail(this.getEmail());
    return person;
  }
}
