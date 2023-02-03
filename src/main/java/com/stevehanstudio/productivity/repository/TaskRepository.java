package com.stevehanstudio.productivity.repository;

import org.springframework.data.repository.CrudRepository;

import com.stevehanstudio.productivity.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
