package com.springboot.restapi.education;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class EducationService {
	public static ArrayList<Student> students=new ArrayList<>();
	static {
	Course courseI1=new Course("courseI1","Fundamentals of Prog.","Learn Prog.",new ArrayList<String>(Arrays.asList("Learn","step-by-step")));
	Course courseI2=new Course("courseI2","Prog.","Learn Prog.",new ArrayList<String>(Arrays.asList("Learn","step-by-step")));
	
	Course courseII1=new Course("courseII1","Python","Learn Prog.",new ArrayList<String>(Arrays.asList("Learn","step-by-step")));
	Course courseII2=new Course("courseII2","Java","Learn Prog.",new ArrayList<String>(Arrays.asList("Learn","step-by-step")));
	
	Student student1=new Student("student1","Anil",new ArrayList<Course>(Arrays.asList(courseI1,courseI2)));
	Student student2=new Student("student2","Hemanth",new ArrayList<Course>(Arrays.asList(courseII1,courseII2)));
	
	students.add(student1);
	students.add(student2);
	}

	public List<Student> retriveAllStudents() {
		return students;
	}

	public Student retriveSpecificStudent(String studentid) {
		Predicate<? super Student> predicate=student -> student.getId().equalsIgnoreCase(studentid);
		Optional<Student> student=students.stream().filter(predicate).findAny();
		if(student.isEmpty()) {return null;}
		return student.get();
	}

	public List<Course> retriveAllStudentCourses(String studentid) {
		Student student=retriveSpecificStudent(studentid);
		if(student==null) {return null;}
		return student.getCourses();
	}

	public Course retriveStudentSpecificCourse(String studentid, String courseid) {
		List<Course> courses= retriveAllStudentCourses(studentid);
		Predicate<? super Course> predicate =course -> course.getId().equalsIgnoreCase(courseid);
		Optional<Course> course=courses.stream().filter(predicate).findAny();
		if(course.isEmpty()) {return null;}
		return course.get();
	}

	public void addcourse(String studentid, Course course) {
		retriveAllStudentCourses(studentid).add(course);
	}

	public String updatecourse(String studentid,String courseid ,Course course) {
		Student student=retriveSpecificStudent(studentid);
		Course ocourse=retriveStudentSpecificCourse(studentid,courseid);
		if(ocourse==null || student==null) {return null;}
		int i=student.getCourses().indexOf(ocourse);
		student.getCourses().set(i, course);
		return courseid;
	}

	public String deletecourse(String studentid, String courseid) {
		Student student=retriveSpecificStudent(studentid);
		Course course=retriveStudentSpecificCourse(studentid,courseid);
		if(course==null || student==null) {return null;}
		student.getCourses().remove(course);
		return courseid;
	}
	
	
}
