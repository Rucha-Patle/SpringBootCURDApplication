package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.Project;
import com.SpringBootCURDApplication.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService ps;
	
	@GetMapping("/allproject")
	public List<Project> getProjectDetail() {
		return ps.getProjectDetail();
	}
	
	@PostMapping("/saveproject")
	public String saveNewProject(@RequestBody Project project) {
		return ps.saveNewProject(project);
	}
	
	@PutMapping("/updateproject/{id}")
	public String UpdateProject(@PathVariable int id, @RequestBody Project project) {
		project.setProjectid(id);
		return ps.UpdateProject(project);
	}
	
	@DeleteMapping("deleteproject/{id}")
	public String DeleteProjectbyID(@PathVariable("id") int id) {
		return ps.DeleteProjectbyID(id);
	}
	
	@GetMapping("/projectBy/{id}")
	public Project getProjectByID(@PathVariable int id) {
		 return ps.getProjectByID(id);
	}
}
