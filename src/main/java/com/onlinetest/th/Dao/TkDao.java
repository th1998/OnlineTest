package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.Question_bank;
import com.onlinetest.th.Model.Tk_stAmount_View;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TkDao {

    /*** 
    * @Description: 添加题库
    * @Param: [question_bank] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/24 
    */ 
    @Insert("insert into question_bank(tk_name,tk_pic,tk_status,tk_explain,tk_dateTime)" +
            "values(#{tk_name},#{tk_pic},#{tk_status},#{tk_explain},#{tk_dateTime})")
    public int addTk(Question_bank question_bank);

    /***
    * @Description: 查询题库所以信息
    * @Param: []
    * @return: java.util.List<com.onlinetest.th.Model.Question_bank>
    * @Author: Tanghao
    * @Date: 2019/10/24
    */
    @Select("select * from question_bank")
    public List<Question_bank> getQuestion_bank();

    /***
    * @Description:  根据题库和试题的视图查询，得到题库信息列表
    * @Param: []
    * @return: java.util.List<com.onlinetest.th.Model.Tk_st_View>
    * @Author: Tanghao
    * @Date: 2019/10/27
    */
    @Select("select *  from tk_stamount")
    public List<Tk_stAmount_View> getTk_st_View();
}
