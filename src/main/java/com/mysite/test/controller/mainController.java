package com.mysite.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.test.DTO.moviesModel;
import com.mysite.test.DTO.userModel;
import com.mysite.test.Mapper.userMapper;


@Controller
public class mainController {
	@Autowired
	private final userMapper um;
	
	public mainController(userMapper umapper) {
		this.um = umapper;
	}

	//메인 페이지 영화목록 나오게끔
	@GetMapping("/")
	public String main(Model model) {
	
	List<moviesModel> movies = um.findMovie_List();
	
	model.addAttribute("movies", movies);	
		
		
	return "main";
	}
	
	//유저리스트 쿼리스트링 사용해서 상세정보 보거나 리스트를 보거나
	@GetMapping("/user/List")
	public String userList(@RequestParam(name ="usersNum",required = false)Integer number,Model model) {
		if(number != null) {
			List<userModel> users = um.finduserNum(number);
			model.addAttribute("users", users);
			
			
			return "userDetail";
		}
		
		return "usersList";
	}
	
	@GetMapping("/moviecreate")
	public String movieCreate() {
		return "movieUpload";
	}
	
	@PostMapping("/moviecreate")
	public String moviecreate() {
		return "redirect:hi";
	}
	
}
