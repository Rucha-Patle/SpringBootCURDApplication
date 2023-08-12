package com.SpringBootCURDApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.CourseDao;
import com.SpringBootCURDApplication.entity.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDao cd;
	
	public List<String> getCourseByTitle() {
		return cd.getCourseByTitle();
	}

	public String saveCourse(Course course) {
		return cd.saveCourse(course);
	}

	public String updateCourse(Course course) {
		return cd.updateCourse(course);
	}

	public String deleteCourse(int id) {
		return cd.deleteCourse(id);
	}

}
