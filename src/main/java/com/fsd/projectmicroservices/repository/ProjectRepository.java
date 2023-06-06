package com.fsd.projectmicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.projectmicroservices.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
	Project findByProjectCode(long ProjectCode);
}
