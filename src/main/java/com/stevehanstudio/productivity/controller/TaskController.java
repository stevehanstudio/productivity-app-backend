package com.stevehanstudio.productivity.controller;

import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.service.TaskService;

import java.util.List;
// import java.lang.Long;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@Tag(name = "Task Controller", description = "API to perform CRUD operations on the Task table.")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

  TaskService taskService;

  @Operation(summary = "Get a task", description = "Retrieves a task given it's ID")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "The task with the given ID does not exist", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))),
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the task", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Task.class))))
  })
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/{id}")
  // public ResponseEntity<Task> getTask(@PathVariable String id) {
  public ResponseEntity<Task> getTask(@PathVariable Long id) {
    return new ResponseEntity<Task>(taskService.getTask(id), HttpStatus.OK);
    // return new ResponseEntity<Task>(taskService.getTask(Long.parseLong(id)), HttpStatus.OK);
  }

  @Operation(summary = "Get all tasks", description = "Retrieves all tasks")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "There are no task", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))),
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all tasks", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Task.class))))
  })
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/all")
  public ResponseEntity<List<Task>> getTasks() {
    return new ResponseEntity<List<Task>>(taskService.getAllTasks(), HttpStatus.OK);
  }

  @Operation(summary = "Update a task", description = "Update a task to the task in the request body given it's ID in the path")
  @ApiResponse(responseCode = "200", description = "Successful update of the task", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Task.class))))
  @PutMapping("/")
  public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task) {
    return new ResponseEntity<Task>(taskService.updateTask(task), HttpStatus.OK);
  }
}
