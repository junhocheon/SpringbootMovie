package com.mysite.test.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class moviesModel{
	
	private int movie_num;
	private String movie_name;
	private int price;
	private LocalDate release_date;
	private LocalDate finish_date;
	private int movie_showtime;
	private String movie_code;
	private String movie_pictrrue;
	
	  public moviesModel() {
	    }

	    // 전체 필드를 초기화하는 생성자
	    public moviesModel(int movieNum, String movieName, int price, LocalDate releaseDate, LocalDate finishDate, int movieShowtime, String movieCode, String moviePicture) {
	        this.movie_num = movieNum;
	        this.movie_name = movieName;
	        this.price = price;
	        this.release_date = releaseDate;
	        this.finish_date = finishDate;
	        this.movie_showtime = movieShowtime;
	        this.movie_code = movieCode;
	        this.movie_pictrrue = moviePicture;
	    }
}
