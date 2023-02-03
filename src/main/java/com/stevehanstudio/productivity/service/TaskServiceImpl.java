package com.stevehanstudio.productivity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.repository.TaskRepository;
import com.stevehanstudio.productivity.exception.TaskNotFoundException;


@Service
public class TaskServiceImpl implements TaskService {

  private TaskRepository taskRepository;

  @Override
  public Task getTask(Long id) {
    Optional<Task> task = taskRepository.findById(id);
    return unwrapTask(task, id);
  }

  @Override
  public Task saveTaskToProject(Task task, Long projectId) {
    return null;
  }

  @Override
  public void deleteTask(Long id) {
    taskRepository.deleteById(id);
  }

  @Override
  public List<Task> getProjectTasks(Long id) {
    return null;
  }

  static Task unwrapTask(Optional<Task> entity, Long id) {
    if (entity.isPresent()) return entity.get();
    else throw new TaskNotFoundException(id);
  }
}
