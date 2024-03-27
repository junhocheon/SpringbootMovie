package com.mysite.test.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class moviesModel{
	
	private int movieNum;
	private String movieName;
	private int price;
	private LocalDate releaseDate;
	private LocalDate finishDate;
	private int movieShowtime;
	private String movieCode;
	private byte[] moviePicture;
	
	  public moviesModel() {
	    }

	    // 전체 필드를 초기화하는 생성자
	    public moviesModel(int movieNum, String movieName, int price, LocalDate releaseDate, LocalDate finishDate, int movieShowtime, String movieCode, byte[] moviePicture) {
	        this.movieNum = movieNum;
	        this.movieName = movieName;
	        this.price = price;
	        this.releaseDate = releaseDate;
	        this.finishDate = finishDate;
	        this.movieShowtime = movieShowtime;
	        this.movieCode = movieCode;
	        this.moviePicture = moviePicture;
	    }
}
