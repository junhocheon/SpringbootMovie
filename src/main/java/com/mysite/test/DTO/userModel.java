package com.mysite.test.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userModel {
	private int users_num;
	private String id;
	private String phone_number;
	private String address;
	private String password;
	private String username;
	
	userModel(){}
	
	userModel(Integer userNum, String id, String pheoNumber,
			String address,String password,String username){
		this.users_num = userNum;
		this.id = id;
		this.phone_number = pheoNumber;
		this.address = address;
		this.password = password;
		this.username = username;
	}
}
