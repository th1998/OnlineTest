package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.CourseDao;
import com.onlinetest.th.Model.Course;
import com.onlinetest.th.Model.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {
    @Resource
    CourseDao courseDao;

    public int addCourse(Course c){
        return courseDao.addCourse(c);
    }

    public List<Course> getCourse(){
        return courseDao.getCourse();
    }

    public List<Course> getCourse(String page, String limit){
        return courseDao.getCourse();
    }


    public List<Course> getOneCourse(Integer c_id){
        return courseDao.getOneCourse(c_id);
    }

    public int jlStudyTime(Record record){
        return courseDao.jlStudyTime(record);
    }

    public List<Record> pdjlStudyTime(Integer u_id,Integer c_id){
        return courseDao.pdjlStudyTime(u_id,c_id);
    }

    public int xgStudyTime(Integer r_id,String progress){
        return courseDao.xgStudyTime(r_id,progress);
    }

    public List<Record> getRecord(String page, String limit,Integer u_id){
        return courseDao.getRecord(u_id);
    }
}
