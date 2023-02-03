package com.stevehanstudio.productivity.exception;

public class TaskNotFoundException extends RuntimeException {

  public TaskNotFoundException(Long id) {
    super("The task with task id: '" + id + "' does not exist in our records");
  }
}
