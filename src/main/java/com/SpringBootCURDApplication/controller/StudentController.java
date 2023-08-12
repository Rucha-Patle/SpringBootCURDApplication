package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.Student;
import com.SpringBootCURDApplication.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable int id) {
		Student student=ss.getStudentByID(id);
		if(student==null)
		{
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(student);
		}
	}
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		return ss.getStudent();
	}
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student student)
	{
		return ss.saveStudent(student);
	}
	
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student) {
		student.setId(id);
		return ss.updateStudent(student);
	}
	
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		return ss.deleteStudent(id);
	}
}
