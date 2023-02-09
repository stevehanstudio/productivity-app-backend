package com.stevehanstudio.productivity.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
// @RequiredArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

  @Id
  private Long id;

  @Column(name = "name")
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  // @JoinTable(
  //   name = "project_task",
  //   joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
  // )
  private List<Task> tasks;

}
