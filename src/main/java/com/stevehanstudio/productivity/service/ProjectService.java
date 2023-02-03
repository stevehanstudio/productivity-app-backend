package com.stevehanstudio.productivity.service;

import com.stevehanstudio.productivity.entity.Project;

import java.util.List;

public interface ProjectService {
  Project getProject(Long id);
  Project createProject(Project project);
  void deleteProject(Long id);
  Project renameProject(Long id, String name);
  List<Project> getAllProjects();
}
