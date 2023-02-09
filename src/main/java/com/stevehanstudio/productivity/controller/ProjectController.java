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
import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Project Controller", description = "API to perform CRUD operation on Project table.")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @Operation(summary = "Get a project based its ID", description = "Returns the project given its ID")
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/{id}")
  public ResponseEntity<Project> getProject(@PathVariable Long id) {
      return new ResponseEntity<>(projectService.getProject(id), HttpStatus.OK);
  }

  @Operation(summary = "Get all projects", description = "Returns all projects in the project table")
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/all")
  public ResponseEntity<List<Project>> getAllProjects() {
    return new ResponseEntity<List<Project>>(projectService.getAllProjects(), HttpStatus.OK);
  }

  @Operation(summary = "Get all the tasks from a project", description = "Retrieve all the tasks from a project given its project ID")
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/{projectId}/tasks")
  public ResponseEntity<List<Task>> getAllTasksFromProject(@PathVariable Long projectId) {
    return new ResponseEntity<>(projectService.getAllTasksFromProject(projectId), HttpStatus.OK);
  }

  @Operation(summary = "Creates a new project", description = "Creates a new project.  Will return an error if there is already a project with the same ID.")
  @PostMapping("/")
  public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
    return new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);
  }

  @Operation(summary = "Add a task to a project", description = "Save a task to a project based on it's project ID")
  @PostMapping("/{projectId}/task")
  public ResponseEntity<Task> saveTaskToProject(@Valid @RequestBody Task task, @PathVariable Long projectId) {
    return new ResponseEntity<>(projectService.saveTaskToProject(task, projectId), HttpStatus.CREATED);
  }

  @Operation(summary = "Rename a project", description = "Uses the project ID to find the project in the project table and replaces it with the project in the request body.")
  @PutMapping("/")
  public ResponseEntity<Project> renameProject(@Valid @RequestBody Project project) {
    return new ResponseEntity<>(projectService.renameProject(project.getId(), project.getName()), HttpStatus.OK);
  }
}
