package com.mysite.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.test.Mapper.userMapper;
import com.mysite.test.model.userModel;

@RestController
public class mainRestController {

	private final userMapper usermapper;
	
	

	public mainRestController(userMapper usermapper) {
		this.usermapper = usermapper;
	}

	@GetMapping("/user/listapi")
	public List<userModel> userList() {
		List<userModel> users = usermapper.findAll();
		return users;
	}
	
	
	
	
}
