package com.SpringBootCURDApplication.configuration;

import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;

import com.SpringBootCURDApplication.entity.BookStore;
import com.SpringBootCURDApplication.entity.Bus;
import com.SpringBootCURDApplication.entity.Course;
import com.SpringBootCURDApplication.entity.Product;
import com.SpringBootCURDApplication.entity.Project;
import com.SpringBootCURDApplication.entity.Student;
import com.SpringBootCURDApplication.entity.Users;

public class CreateConfiguration {

	public static SessionFactory createConfiguration() {
	Configuration cfg=new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Product.class);
	cfg.addAnnotatedClass(Student.class);
	cfg.addAnnotatedClass(Course.class);
	cfg.addAnnotatedClass(Users.class);
	cfg.addAnnotatedClass(Project.class);
	cfg.addAnnotatedClass(BookStore.class);
	cfg.addAnnotatedClass(Bus.class);
	SessionFactory sf =cfg.buildSessionFactory();
	return sf;
	}
	
}
