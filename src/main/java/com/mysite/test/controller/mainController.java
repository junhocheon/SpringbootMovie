package com.mysite.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.test.Mapper.userMapper;
import com.mysite.test.model.userModel;


@Controller
public class mainController {

	@GetMapping("/")
	public String main() {
		return "redirect:/user/List";
	}
	
	
	
	@Autowired
	private final userMapper um;
		
	public mainController(userMapper umapper) {
		this.um = umapper;
	}

	@GetMapping("/user/List")
	public String userList(@RequestParam(name ="usersNum",required = false)Integer number,Model model) {
		if(number != null) {
			List<userModel> users = um.finduserNum(number);
			model.addAttribute("users", users);
			
			
			return "userDetail";
		}
		
		return "usersList";
	}
	
	
	
}
