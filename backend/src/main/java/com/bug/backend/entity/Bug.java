package com.bug.backend.entity;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class Bug implements Cloneable {

  @Id
  @GeneratedValue
  private Long bugId;

  @NotNull
  private String description;

  @NotNull
  private String topic;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Person> assignees;

  @OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @NotNull
  private Person reporter;

  @OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Person currentAssignee;

  @Enumerated(EnumType.STRING)
  @NotNull
  private BugState state;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updated;

  @Override
  public Object clone() {
    Bug clone = new Bug();
    clone.setAssignees(this.getAssignees());
    clone.setBugId(this.getBugId());
    clone.setTopic(this.getTopic());
    clone.setUpdated(this.getUpdated());
    clone.setCreated(this.getCreated());
    clone.setDescription(this.getDescription());
    clone.setReporter(this.getReporter());
    clone.setState(this.getState());
    clone.setCurrentAssignee(this.getCurrentAssignee());
    return clone;
  }
}
