package com.mysite.test.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.test.model.userModel;

@Mapper
public interface userMapper {

	@Select("select * from users")
	List<userModel> findAll();

	@Select("select * from users where users_num = #{userNum}")
	List<userModel> finduserNum(@Param("userNum")Integer userNum);

}
