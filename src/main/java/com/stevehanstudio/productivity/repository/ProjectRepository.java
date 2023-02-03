package com.stevehanstudio.productivity.repository;

import org.springframework.data.repository.CrudRepository;

import com.stevehanstudio.productivity.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
