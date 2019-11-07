package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginDao {
    //登录
    @Select("select * from user where UserName = #{UserName} and UserPass = #{UserPass}")
    public List<User> login(@Param("UserName") String UserName, @Param("UserPass") String UserPass);
}
