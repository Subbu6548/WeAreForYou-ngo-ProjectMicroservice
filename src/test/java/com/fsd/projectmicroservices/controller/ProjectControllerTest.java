package com.fsd.projectmicroservices.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fsd.projectmicroservices.ProjectMicroservicesApplication;
import com.fsd.projectmicroservices.entity.Project;
import com.fsd.projectmicroservices.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private ProjectService pservice;
	@Test
	public void createProject() throws Exception {
		Project project =new Project();
		 project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    
		when(pservice.saveProject(project)).thenReturn(project);
		
	}
	@Test
	public void getprojects() throws Exception
	{
		Project project =new Project();
		
	    project.setId(1L);
	    project.setProject_name("wearetheir");
	    project.setProject_desc("we are there for you");
	    project.setProjectCode(101L);
	    project.setProjectplace("nellore");
	    project.setProjectdate("3-5-23");
	    
	    Project project1 =new Project();
	    project1.setId(2L);
	    project1.setProject_name("wecarefor");
	    project1.setProject_desc("we care for you");
	    project1.setProjectCode(102L);
	    project1.setProjectplace("nellore");
	    project1.setProjectdate("3-8-23");
	    
	    List<Project> projects=new ArrayList<Project>();
		projects.add(project);
		projects.add(project1);
		when(pservice.getAllProjects()).thenReturn(projects);

		mvc.perform(get("/api/project").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
		
	}
}
