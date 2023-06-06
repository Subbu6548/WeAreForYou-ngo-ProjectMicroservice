package com.fsd.projectmicroservices.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.projectmicroservices.entity.Project;
import com.fsd.projectmicroservices.repository.ProjectRepository;



@RunWith(SpringRunner.class)
public class ProjectServiceImplTest {

	@InjectMocks
	private ProjectServiceImpl pser;
	
	@Mock
	private ProjectRepository prepo;
	
	@Before
	public void setUp() {
		Project project =new Project();
	
		    project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    Mockito.when(prepo.save(project)).thenReturn(project);
		    
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
			Mockito.when(prepo.findAll()).thenReturn(projects);
				

	}
	@Test
	 public void saveProject() 
	{
		Project project=new Project();
		project.setId(1L);
		project.setProject_name("wearetheir");
	    project.setProject_desc("we are there for you");
	    project.setProjectCode(101L);
	    project.setProjectplace("nellore");
	    project.setProjectdate("3-5-23");
		pser.saveProject(project);
		verify(prepo, times(1)).save(project);
	}
	@Test
	public void getAllProjects() {

		List<Project> projects = pser.getAllProjects();
		Assert.assertEquals(projects.size(), 2);
	}
	@Test
	public void getProjectByCode() {
		Project project =new Project();
		
	    project.setId(1L);
	    project.setProject_name("wearetheir");
	    project.setProject_desc("we are there for you");
	    project.setProjectCode(101L);
	    project.setProjectplace("nellore");
	    project.setProjectdate("3-5-23");
	    pser.saveProject(project);
		Project foundProject = prepo.findByProjectCode(101L);
		
	}
}
