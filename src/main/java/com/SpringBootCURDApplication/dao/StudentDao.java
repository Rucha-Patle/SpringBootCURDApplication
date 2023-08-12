package com.SpringBootCURDApplication.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.Student;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory sf;
	
	public Student getStudentByID(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Student student =session.get(Student.class, id);
		tr.commit();
		return student;
	}

	public List<Student> getStudent() {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(Student.class);
		List<Student> student =crt.list();
		tr.commit();
		return student;
	}

	public String saveStudent(Student student) {
			Session session=sf.openSession();
			Transaction tr=session.beginTransaction();
			session.save(student);
			tr.commit();
			return "Student saved";
	}

	public String updateStudent(Student student) {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		try {
			session.update(student);
			tr.commit();
			return "Student updated";
		}
		catch(Exception e)
		{
			return "Student of this id is not present, please enter again";
		}
	}

	public String deleteStudent(int id) {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		Student student =session.get(Student.class, id);
		try {
			session.delete(student);
			tr.commit();
			return "Student deleted";
		}
		catch(Exception e)
		{
			return "Student of this id is not present, please enter again";
		}
	}

}
