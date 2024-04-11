package com.mysite.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.test.DTO.userModel;
import com.mysite.test.Mapper.userMapper;

@RestController
public class mainRestController {

	private final userMapper usermapper;
	
	
	
	public mainRestController(userMapper usermapper) {
		this.usermapper = usermapper;
	}
	
	//userlist의 데이터 api형식으로 생성
	@GetMapping("/user/listapi")
	public List<userModel> userList() {
		List<userModel> users = usermapper.findAll();
		return users;
	}
	
	
	
	
}
