package com.fsd.projectmicroservices.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.projectmicroservices.entity.Project;
import com.fsd.projectmicroservices.repository.ProjectRepository;

import com.fsd.projectmicroservices.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService { 
	 @Autowired
	 private ProjectRepository projectRepository;

	@Override
	 public Project saveProject(Project project) 
	 {
	 Project savedProject = projectRepository.save(project);
	 return savedProject;
	 }  
	@Override
	 public Project getProjectByCode(long projectCode) {
	 Project foundProject = projectRepository.findByProjectCode(projectCode);
	 return foundProject;
	 }
	@Override
	public List<Project> getAllProjects() 
	{
		List<Project> projects = new ArrayList<Project>();
        projectRepository.findAll().forEach(project1 -> projects.add(project1));
        return projects;
	}

}
