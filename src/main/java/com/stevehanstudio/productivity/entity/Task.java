package com.stevehanstudio.productivity.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.*;

// enum Status {
//   "To do",
//   "In progress",
//   "Done"
// }

@Getter
@Setter
@AllArgsConstructor
// @RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Task {

  @Id
  Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "date_due")
  private Date dateDue;

  @Column(name = "date_created")
  private Date dateCreated;

  @Column(name = "status")
  private String status;

  @Column(name = "tags")
  private String[] tags;

  @Column(name = "notes")
  private String notes;

  // @Column(name = "project_id")
  // private Long projectId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Project project;
}
