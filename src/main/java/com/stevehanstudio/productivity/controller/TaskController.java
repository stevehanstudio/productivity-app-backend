package com.stevehanstudio.productivity.controller;

import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

  TaskService taskService;

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTask(@PathVariable Long id) {
    return new ResponseEntity<Task>(taskService.getTask(id), HttpStatus.OK);
  }

}
