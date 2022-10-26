package com.spring1.SBP1.todo;
/*package com.spring1.SBP1.todo;

import java.util.List;

import javax.validation.Valid;

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


//@Controller
public class ToDoController {
	
	@RequestMapping("todolist")
	public String todolist(Model m,ToDo t1) {
		List<ToDo> ltd=t1.distodo(getLoggedinUserName());
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
		if(result.hasErrors()) { 
			return "addtodo";
			}
		t1.setUsername(getLoggedinUserName());
		t1.AddTodo(t1,getLoggedinUserName());
		return "redirect:todolist";
	}
	@GetMapping("update-todo")
	public String uptodo(@RequestParam int id, ToDo t1,ModelMap m) {
		ToDo todo=t1.FindById(id);
		m.put("t1",todo);
		return "addtodo";
	}
	@RequestMapping("delete-todo")
	public String deltodo(@RequestParam int id,ToDo t1) {
		t1.Delete(id,getLoggedinUserName());
		return "redirect:todolist";
	}

	private String getLoggedinUserName() {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}*/
