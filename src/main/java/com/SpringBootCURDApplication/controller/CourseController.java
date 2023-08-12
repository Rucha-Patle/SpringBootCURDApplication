package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.Course;
import com.SpringBootCURDApplication.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cs;
	
	@GetMapping("/coursetitle")
	public List<String> getCourseByTitle() {
		return cs.getCourseByTitle();
	}
	
	@PostMapping("/savecourse")
	public String saveCourse(@RequestBody Course course) {
		return cs.saveCourse(course);
	}
	
	@PutMapping("/{id}/course")
	public String updateCourse(@PathVariable int id,@RequestBody Course course)
	{
		course.setCourseID(id);
		return cs.updateCourse(course);
	}
	
	@DeleteMapping("course/{id}")
	public String deleteCourse(@PathVariable("id") int id)
	{
		return cs.deleteCourse(id);
	}
}
