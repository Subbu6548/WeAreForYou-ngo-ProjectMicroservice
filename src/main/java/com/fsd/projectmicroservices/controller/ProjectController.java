package com.fsd.projectmicroservices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.projectmicroservices.entity.Project;
import com.fsd.projectmicroservices.service.ProjectService;


import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	//saving projects of our ngo organisation weareforyou
	@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping
	public Project createProject(@RequestBody Project project)
	{
		return projectService.saveProject(project);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/{project_code}")
	public Project getProjectByCode(
			@PathVariable(name="project_code") long project_code)
	{
		return projectService.getProjectByCode(project_code);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping
	private List<Project> getprojects() 
	{
	return projectService.getAllProjects();
	}

	

}
