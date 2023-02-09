package com.stevehanstudio.productivity.service;

import java.util.List;

import com.stevehanstudio.productivity.entity.Task;

public interface TaskService {
  Task getTask(Long id);
  List<Task> getAllTasks();
  Task saveTaskToProject(Task task, Long projectId);
  void deleteTask(Long id);
  List<Task> getProjectTasks(Long projectId);
  Task updateTask(Task task);
}
