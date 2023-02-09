package com.stevehanstudio.productivity.service;

import com.stevehanstudio.productivity.entity.Project;
import com.stevehanstudio.productivity.entity.Task;

import java.util.List;

public interface ProjectService {
  Project getProject(Long id);
  Project createProject(Project project);
  Task saveTaskToProject(Task task, Long projectId);
  void deleteProject(Long id);
  List<Task> getAllTasksFromProject(Long projectId);
  Project renameProject(Long id, String name);
  List<Project> getAllProjects();
}
