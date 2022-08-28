package com.bug.backend.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class History {

  @Id
  @GeneratedValue
  private Long id;

  private String field;

  @Column(length = 100000)
  private String newValue;

  @Column(length = 100000)
  private String oldValue;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updated;

  @ManyToOne(targetEntity = Bug.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "bugId")
  private Bug bug;

}
