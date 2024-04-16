package com.mysite.test.Mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.test.DTO.moviesModel;
import com.mysite.test.DTO.userModel;

@Mapper
public interface userMapper {

	@Select("select * from users")
	List<userModel> findAll();

	@Select("select * from users where users_num = #{userNum}")
	List<userModel> finduserNum(@Param("userNum")Integer userNum);

	
	@Select("select * from movie_list")
	List<moviesModel> findMovie_List();
	
	
	@Insert("INSERT INTO movie_list (movie_name, price, relese_date, finish_date, movie_showtime, movie_code, movie_pictrue, movie_details) " +
	        "VALUES (#{movie_name}, #{price}, #{relese_date}, #{finish_date}, #{movie_showtime}, #{movie_code}, CONCAT('images/', #{movie_pictrue}), #{movie_details})")
	void createMovie(@Param("movie_name") String movie_name,
	                              @Param("price") int price,
	                              @Param("relese_date") LocalDate relese_date,
	                              @Param("finish_date") LocalDate finish_date,
	                              @Param("movie_showtime") int movie_showtime,
	                              @Param("movie_code") String movie_code,
	                              @Param("movie_pictrue") String movie_pictrue,
	                              @Param("movie_details") String movie_details);

}
