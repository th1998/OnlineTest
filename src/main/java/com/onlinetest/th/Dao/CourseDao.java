package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CourseDao {
    /***
    * @Description:  添加课程资源信息
    * @Param: [c]
    * @return: int
    * @Author: Tanghao
    * @Date: 2019/10/29
    */
    @Insert("insert into course(c_name,c_teacher,c_type,c_status,c_imgurl,c_videourl,c_explain) values(#{c_name},#{c_teacher},#{c_type},#{c_status},#{c_imgurl},#{c_videourl},#{c_explain})")
    public int addCourse(Course c);

    /*** 
    * @Description: 查询所有课程信息
    * @Param: [c] 
    * @return: java.util.List<com.onlinetest.th.Model.Course> 
    * @Author: Tanghao 
    * @Date: 2019/10/30 
    */ 
    @Select("select * from course")
    public List<Course> getCourse();

    /***
    * @Description:  根据id查询一条课程信息
    * @Param: [c_id]
    * @return: java.util.List<com.onlinetest.th.Model.Course>
    * @Author: Tanghao
    * @Date: 2019/10/31
    */
    @Select("select * from course where c_id=#{c_id}")
    public List<Course> getOneCourse(Integer c_id);
}
