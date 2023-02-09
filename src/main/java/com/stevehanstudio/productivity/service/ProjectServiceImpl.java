package com.stevehanstudio.productivity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stevehanstudio.productivity.entity.Project;
import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.exception.EntityNotFoundException;
import com.stevehanstudio.productivity.repository.ProjectRepository;
import com.stevehanstudio.productivity.repository.TaskRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

  private ProjectRepository projectRepository;
  private TaskRepository taskRepository;

  @Override
  public Project getProject(Long id) {
    Optional<Project> project = projectRepository.findById(id);
    return unwrapProject(project, id);
  }

  @Override
  public Project createProject(Project project) {
    return projectRepository.save(project);
  }

  @Override
  public Task saveTaskToProject(Task task, Long projectId) {
    Optional<Project> project = projectRepository.findById(projectId);
    task.setProject(unwrapProject(project, projectId));
    return taskRepository.save(task);
  }

  @Override
  public void deleteProject(Long id) {
    projectRepository.deleteById(id);
  }

  @Override
  public Project renameProject(Long id, String name) {
    Optional<Project> project = projectRepository.findById(id);
    Project unwrappedProject = unwrapProject(project, id);
    unwrappedProject.setName(name);
    return projectRepository.save(unwrappedProject);
  }

  @Override
  public List<Task> getAllTasksFromProject(Long projectId) {
    // Optional<Project> project = projectRepository.findById(projectId);
    // Project unwrappedProject = unwrapProject(project, projectId);
    return (List<Task>)taskRepository.findByProjectId(projectId);
  }

  @Override
  public List<Project> getAllProjects() {
    return (List<Project>)projectRepository.findAll();
  }

  static Project unwrapProject(Optional<Project> entity, Long id) {
    if (entity.isPresent()) return entity.get();
    else throw new EntityNotFoundException(id, Project.class);
  }
}
