package com.mysite.test.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.test.DTO.moviesModel;
import com.mysite.test.DTO.userModel;
import com.mysite.test.Mapper.userMapper;
import com.mysite.test.service.fileUpload;


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
	public String moviecreate(
			@RequestParam(name = "movie_name")String movie_name,
			@RequestParam(name = "price")int price,
			@RequestParam(name = "release_date")LocalDate release_date,
			@RequestParam(name = "finish_date")LocalDate finish_date,
			@RequestParam(name = "movie_showtime")int movie_showtime,
			@RequestParam(name = "movie_code")String movie_code,
			@RequestParam("movie_pictrue")MultipartFile movie_pcitrue,
			@RequestParam(name = "movie_details")String movie_details) throws IOException {
			
		
			um.createMovie(movie_name, price, release_date, finish_date, movie_showtime,movie_code,fileUpload.upFile(movie_pcitrue),  movie_details);
			
		
		return "redirect:/";
	}
	
}
