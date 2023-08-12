package com.SpringBootCURDApplication.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.Project;

@Repository
public class ProjectDao {
	
	@Autowired
	private SessionFactory sf;
	
	public List<Project> getProjectDetail() {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(Project.class);
		List<Project> projects =crt.list();
		tr.commit();
		return projects;
	}

	public String saveNewProject(Project project) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		session.save(project);
		tr.commit();
		return "New Project Added successfully";
	}

	public String UpdateProject(Project project) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		try{
			session.update(project);
			tr.commit();
			return "Project updated";
		}
		catch (Exception e) {
			return "Project of this id is not present, please enter again";
		}
	}

	public String DeleteProjectbyID(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Project project =session.get(Project.class, id);
		try {
			session.delete(project);
			tr.commit();
			return "Project deleted";
		} catch (Exception e) {
			return "Project of this id is not present, please enter again";
		}
	}

	public Project getProjectByID(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Project project=session.get(Project.class, id);
		tr.commit();
		return project;
	}

}
