package com.stevehanstudio.productivity.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevehanstudio.productivity.entity.Project;
import com.stevehanstudio.productivity.service.ProjectService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @GetMapping("/{id}")
  public ResponseEntity<Project> getProject(@RequestParam Long id) {
      return new ResponseEntity<>(projectService.getProject(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Project>> getAllProjects() {
    return new ResponseEntity<List<Project>>(projectService.getAllProjects(), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
    return new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);
  }
}
