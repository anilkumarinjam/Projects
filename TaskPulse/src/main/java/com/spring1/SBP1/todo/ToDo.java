package com.spring1.SBP1.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class ToDo {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=5, message="Enter atleast 5 Characters")
	private String description;
	private LocalDate targetdate;
	private boolean done;

	public ToDo() {
		
	}
	public ToDo(int id,String username,String description,LocalDate targetdate,boolean done) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", targetdate="
				+ targetdate + ", done=" + done + "]";
	}
}
	/*
	public static List<ToDo> todolist=new ArrayList<>();
	static {
		todolist.add(new ToDo(1,"Anil","Java-Core",LocalDate.now(),false));
		todolist.add(new ToDo(2,"Anil","Spring Boot",LocalDate.now(),false));
		todolist.add(new ToDo(1,"Praveen","Docker",LocalDate.now(),false));
		todolist.add(new ToDo(2,"Praveen","Kubernetes",LocalDate.now(),false));
	}
	public void AddTodo(ToDo todo, String username) {
		int a=0;
		for(ToDo t:todolist) {
			if(t.getId()==todo.getId() && t.getUsername().equals(username)) {
				t.setDescription(todo.getDescription());
				t.setTargetdate(todo.getTargetdate());
				t.setDone(todo.isDone());
				a+=1;
			}
		}
		if(a==0){
		todolist.add(todo);
		}
	}
	public List<ToDo> distodo(String username){
		Predicate<ToDo> predicate=todo ->todo.getUsername().equals(username);
		return todolist.stream().filter(predicate).toList();
	}
	public void Delete(int id,String username) {
		for(ToDo t1:todolist) {
			if(t1.getId()==id && t1.getUsername().equals(username)) {todolist.remove(t1);break;}
		}
	}
	public void Update(ToDo t1) {
		for(ToDo todo:todolist) {
			if(todo.getId()==t1.getId()) {todo.setDescription(t1.getDescription());break;}
		}
	}
	public ToDo FindById(int id) {
		for(ToDo todo:todolist) {
			if(todo.getId()==id) {return todo;}
		}
		return new ToDo();
	}
}*/
