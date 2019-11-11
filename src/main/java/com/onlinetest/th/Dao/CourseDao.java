package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.Course;
import com.onlinetest.th.Model.Record;
import org.apache.ibatis.annotations.*;
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

    /*** 
    * @Description: 没学习记录，就插入 
    * @Param: [record] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/11/11 
    */ 
    @Insert("insert into record(u_id,c_id,u_name,c_name,c_teacher,progress) " +
            "values(#{u_id},#{c_id},#{u_name},#{c_name},#{c_teacher},#{progress})")
    public int jlStudyTime(Record record);

    /*** 
    * @Description: 判断是否有学习记录
    * @Param: [u_id, c_id] 
    * @return: java.util.List<com.onlinetest.th.Model.Record> 
    * @Author: Tanghao 
    * @Date: 2019/11/11 
    */ 
    @Select("select * from record where u_id =#{u_id} and c_id=#{c_id}")
    public List<Record> pdjlStudyTime(@Param("u_id") Integer u_id, @Param("c_id")Integer c_id);
    
    /*** 
    * @Description: 有学习记录，修改学习记录进度 
    * @Param: [r_id, progress] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/11/11 
    */ 
    @Update("update record set progress = #{progress} where r_id = #{r_id}")
    public int xgStudyTime(@Param("r_id")Integer r_id,@Param("progress")String progress);


    @Select("select * from record where u_id = #{u_id}")
    public List<Record> getRecord(Integer u_id);
}
