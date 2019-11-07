package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.CourseDao;
import com.onlinetest.th.Model.Course;
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
}
