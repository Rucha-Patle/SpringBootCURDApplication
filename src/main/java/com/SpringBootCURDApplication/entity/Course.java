package com.SpringBootCURDApplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

	private int courseID;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Id
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Course(int courseID, String title, LocalDate startDate, LocalDate endDate) {
		super();
		this.courseID = courseID;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Course() {
		super();
	}
	
	
	
}
