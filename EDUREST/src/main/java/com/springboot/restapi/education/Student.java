package com.springboot.restapi.education;

import java.util.ArrayList;

public class Student {
	private String id;
	private String Name;
	private ArrayList<Course> courses;
	public Student() {}
	public Student(String id, String name, ArrayList<Course> courses) {
		super();
		this.id = id;
		Name = name;
		this.courses = courses;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return Name;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", courses=" + courses + "]";
	}
}
