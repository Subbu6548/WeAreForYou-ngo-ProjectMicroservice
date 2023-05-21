package com.fsd.projectmicroservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.projectmicroservices.entity.Project;

@Service
public interface ProjectService {
    public Project saveProject(Project project);
    public Project getProjectByCode(long projectCode); 
    public List<Project> getAllProjects(); 
}
