package com.stevehanstudio.productivity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stevehanstudio.productivity.entity.Project;
import com.stevehanstudio.productivity.exception.EntityNotFoundException;
import com.stevehanstudio.productivity.repository.ProjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

  private ProjectRepository projectRepository;

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
  public void deleteProject(Long id) {

  }

  @Override
  public Project renameProject(Long id, String name) {

    return null;
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
