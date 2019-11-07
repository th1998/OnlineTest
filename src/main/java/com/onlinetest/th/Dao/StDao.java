package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.Test_question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StDao {

    /*** 
    * @Description: 添加试题
    * @Param: [tq] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/25
    */ 
    @Insert("insert into test_question(tk_id,st_type,st_question,st_a,st_b,st_c,st_d,st_t,st_f,st_answer,st_analyze)" +
            "values(#{tk_id},#{st_type},#{st_question},#{st_a},#{st_b},#{st_c},#{st_d},#{st_t},#{st_f},#{st_answer},#{st_analyze})")
    public int addSt(Test_question tq);
}
