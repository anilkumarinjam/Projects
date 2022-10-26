package com.springboot.restapi.education;

import java.util.ArrayList;

public class Course {
	private String id;
	private String name;
	private String description;
	private ArrayList<String> steps;
	public Course() {}
	public Course(String id, String name, String description, ArrayList<String> steps) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.steps = steps;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<String> getSteps() {
		return steps;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", steps=" + steps + "]";
	}
}
