package com.spring1.SBP1.todo;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ToDoControllerJpa {
	@Autowired
	ToDoRepository tdr;
	@RequestMapping("todolist")
	public String todolist(Model m,ToDo t1) {
		List<ToDo> ltd=tdr.findByUsername(getLoggedinUserName());
		m.addAttribute("ltd",ltd);
		return "todo";
	}
	@GetMapping("add-todo")
	public String addtodo(ModelMap m) {
		ToDo t1=new ToDo();
		m.put("t1",t1);
		return "addtodo";
	}
	@PostMapping("add-todo")
	public String addtodo(@ModelAttribute("t1") @Valid ToDo t1, BindingResult result) {
		t1.setUsername(getLoggedinUserName());
		
		if(result.hasErrors()) { 
			return "addtodo";
			}
		tdr.save(t1);	
		return "redirect:todolist";
	}
	@GetMapping("update-todo")
	public String uptodo(@RequestParam int id, ToDo t1,ModelMap m) {
		ToDo todo=tdr.findById(id).get();
		m.put("t1",todo);
		return "addtodo";
	}
	@RequestMapping("delete-todo")
	public String deltodo(@RequestParam int id) {
		tdr.deleteById(id);
		return "redirect:todolist";
	}

	private String getLoggedinUserName() {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
