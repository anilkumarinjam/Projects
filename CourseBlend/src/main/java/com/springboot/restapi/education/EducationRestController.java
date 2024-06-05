package com.springboot.restapi.education;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EducationRestController {
	
	@Autowired
	EducationService es;
	
	@GetMapping("/students")
	public List<Student> retriveAllStudents() {
		List<Student> students=es.retriveAllStudents();
		return students;
	}
	
	@GetMapping("/students/{studentid}")
	public Student retriveSpecificStudent(@PathVariable String studentid) {
		Student student=es.retriveSpecificStudent(studentid);
		if(student==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return student;
	}
	
	@GetMapping("/students/{studentid}/courses")
	public List<Course> retriveAllStudentCourses(@PathVariable String studentid) {
		List<Course> courses=es.retriveAllStudentCourses(studentid);
		if(courses==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return courses;
	}
	
	@GetMapping("/students/{studentid}/courses/{courseid}")
	public Course retriveStudentSpecificCourses(@PathVariable String studentid,@PathVariable String courseid) {
		Course course=es.retriveStudentSpecificCourse(studentid,courseid);
		if(course==null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
		return course;
	}
		
	@PostMapping("/students/{studentid}/courses")
	public ResponseEntity<Object> addcourse(@PathVariable String studentid,@RequestBody Course course) {
		es.addcourse(studentid,course);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping("/students/{studentid}/courses/{courseid}")
	public ResponseEntity<Object> updatecourse(@PathVariable String studentid,@PathVariable String courseid,@RequestBody Course course) {
		String s=es.updatecourse(studentid,courseid,course);
		if(s==null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/students/{studentid}/courses/{courseid}")
	public ResponseEntity<Object> deletecourse(@PathVariable String studentid,@PathVariable String courseid) {
		String s=es.deletecourse(studentid,courseid);
		if(s==null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
		return ResponseEntity.noContent().build();
	}
	
}
