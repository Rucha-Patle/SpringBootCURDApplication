package com.SpringBootCURDApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.ProjectDao;
import com.SpringBootCURDApplication.entity.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao pd;

	public List<Project> getProjectDetail() {
		return pd.getProjectDetail();
	}

	public String saveNewProject(Project project) {
		return pd.saveNewProject(project);
	}

	public String UpdateProject(Project project) {
		return pd.UpdateProject(project);
	}

	public String DeleteProjectbyID(int id) {
		return pd.DeleteProjectbyID(id);
	}

	public Project getProjectByID(int id) {
		return pd.getProjectByID(id);
	}

}
