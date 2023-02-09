package com.stevehanstudio.productivity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import com.stevehanstudio.productivity.entity.Task;
import com.stevehanstudio.productivity.repository.TaskRepository;
import com.stevehanstudio.productivity.exception.TaskNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

  private TaskRepository taskRepository;

  @Override
  public Task getTask(Long id) {
    Optional<Task> task = taskRepository.findById(id);
    return unwrapTask(task, id);
  }

  @Override
  // @Transactional(readOnly = false)
  public List<Task> getAllTasks() {
    return (List<Task>)taskRepository.findAll();
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

  // ???
  @Override
  public Task updateTask(Task task) {
    Optional<Task> taskOptional = taskRepository.findById(task.getId());
    Task unwrappedTask = unwrapTask(taskOptional, task.getId());
    return taskRepository.save(unwrappedTask);
  }

  static Task unwrapTask(Optional<Task> entity, Long id) {
    if (entity.isPresent()) return entity.get();
    else throw new TaskNotFoundException(id);
  }
}
