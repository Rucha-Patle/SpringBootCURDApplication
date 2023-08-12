package com.SpringBootCURDApplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.StudentDao;
import com.SpringBootCURDApplication.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao sd;
	
	public Student getStudentByID(int id) {
		return sd.getStudentByID(id);
	}

	public List<Student> getStudent() {
		return sd.getStudent();
	}

	public String saveStudent(Student student) {
		return sd.saveStudent(student);
	}

	public String updateStudent(Student student) {
		return sd.updateStudent(student);
	}

	public String deleteStudent(int id) {
		return sd.deleteStudent(id);
	}

}
