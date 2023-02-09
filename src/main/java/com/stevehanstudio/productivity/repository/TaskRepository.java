package com.stevehanstudio.productivity.repository;

import org.springframework.data.repository.CrudRepository;

import com.stevehanstudio.productivity.entity.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
  List<Task> findByProjectId(Long projectId);
}
