package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 8633415090390966715L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "ROLL_NUMBER")
	private int rollNumber;
	@Column(name = "COURSE")
	private String course;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int id, String studentName, int rollNumber, String course) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.course = course;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String toString() {
		return "ROLL Number: " + rollNumber + "| Name: " + studentName + "| Course: " + course;
	}
}