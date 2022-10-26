package com.spring1.SBP1.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	@RequestMapping("welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/")
	public String gowelcome(Model m) {
		m.addAttribute("name",getLoggedinUserName());
		return "welcome";
	}
	private String getLoggedinUserName() {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
