package com.SpringBootCURDApplication.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.Course;

@Repository
public class CourseDao {

	@Autowired
	private SessionFactory sf;

	public List<String> getCourseByTitle() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Course.class);
		crt.setProjection(Projections.property("title"));
		List<String> coursename = crt.list();

		List<String> al = new ArrayList<>();
		for (String courseName : coursename) {
			al.add(courseName);
		}
		tr.commit();
		return al;
	}

	public String saveCourse(Course course) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(course);
		tr.commit();
		return "Course saved";
	}

	public String updateCourse(Course course) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(course);
			tr.commit();
			return "Course Updated";
		} catch (Exception e) {
			return "Course of this id is not present, please enter again";
		}
	}

	public String deleteCourse(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Course course = session.get(Course.class, id);
		try {
			session.delete(course);
			tr.commit();
			return "Course deleted";
		} catch (Exception e) {
			return "Course of this id is not present, please enter again";
		}
	}

}
