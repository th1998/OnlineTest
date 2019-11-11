package com.onlinetest.th.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onlinetest.th.Model.Course;
import com.onlinetest.th.Model.Question_bank;
import com.onlinetest.th.Model.Record;
import com.onlinetest.th.Model.ResultMsg;
import com.onlinetest.th.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /***
    * @Description:  上传视频资源到服务器
    * @Param: [file]
    * @return: java.util.Map
    * @Author: Tanghao
    * @Date: 2019/10/29
    */
    @PostMapping("/uploadVideo")
    @ResponseBody
    public Map uploadVideo(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException, ParseException {
        Map<String,String> map = new HashMap<>();

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"public/video/upload/");
        if(!upload.exists()) upload.mkdirs();
        String realPath = upload.getAbsolutePath();
//        System.out.println("realPath:"+realPath);
//        System.out.println("upload url:"+upload.getAbsolutePath());

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date=df.format(new Date());
//        System.out.println("当前时间:"+date);

        String newFileName = file.getOriginalFilename().split("\\.")[0]+date+"."+file.getOriginalFilename().split("\\.")[1];
        System.out.println("文件名:"+newFileName);

        File filepath = new File(path, newFileName);
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }

        String serverPath = realPath+"\\"+newFileName;
        serverPath = serverPath.replaceAll("\\\\", "/");
        System.out.println("文件在服务器的位置："+serverPath);
        String spath = "/upload/"+newFileName;

        if(spath.contains(".png")||spath.contains(".jpg")||spath.contains(".jpeg")){
            map.put("imageurl",spath);
        }else{
            map.put("videourl",spath);
        }

        File ff = new File(serverPath);
        file.transferTo(ff);

        System.out.println(spath);

        return map;
        }

        /*** 
        * @Description: 添加课程资源信息
        * @Param: [c] 
        * @return: com.onlinetest.th.Model.ResultMsg 
        * @Author: Tanghao 
        * @Date: 2019/10/29 
        */ 
    @RequestMapping("/addCourse")
    @ResponseBody
    public ResultMsg addCourse(Course c){
        Course course = new Course();
        course.setC_name(c.getC_name());
        course.setC_teacher(c.getC_teacher());
        course.setC_type(c.getC_type());
        course.setC_status(c.getC_status());
        course.setC_imgurl(c.getC_imgurl());
        course.setC_videourl(c.getC_videourl());
        course.setC_explain(c.getC_explain());
        int i = courseService.addCourse(course);
        if(i>0){
            return new ResultMsg(1,"课程资源添加成功！");
        }else{
            return new ResultMsg(1,"课程资源添加失败！");
        }
    }

    /*** 
    * @Description: 查询所有课程信息
    * @Param: [c] 
    * @return: java.util.List<com.onlinetest.th.Model.Course> 
    * @Author: Tanghao 
    * @Date: 2019/10/30 
    */ 
    @RequestMapping("/getCourse")
    @ResponseBody
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @RequestMapping("/getCourseList")
    @ResponseBody
    public Map getCourse(String page, String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        List<Course> list = courseService.getCourse(page,limit);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }

    /*** 
    * @Description: 根据id查询一条课程信息
    * @Param: [c_id] 
    * @return: java.util.List<com.onlinetest.th.Model.Course> 
    * @Author: Tanghao 
    * @Date: 2019/10/31 
    */
    @RequestMapping("/getOneCourse")
    @ResponseBody
    public List<Course> getOneCourse(Integer c_id){
        return courseService.getOneCourse(c_id);
    }

    @RequestMapping("/jlStudyTime")
    @ResponseBody
    public ResultMsg jlStudyTime(String progress,Integer c_id,String c_name,String c_teacher,Integer u_id,String u_name){
//        System.out.println(progress);
//        System.out.println(c_id);
//        System.out.println(c_name);
//        System.out.println(c_teacher);
//        System.out.println(u_id);
//        System.out.println(u_name);
        Record r = new Record();
        r.setU_id(u_id);
        r.setC_id(c_id);
        r.setC_name(c_name);
        r.setC_teacher(c_teacher);
        r.setU_name(u_name);
        r.setProgress(progress);

        int i = courseService.jlStudyTime(r);
        if(i>0){
            return new ResultMsg(1,"记录成功！");
        }else{
            return new ResultMsg(1,"记录失败！");
        }
    }

    @RequestMapping("/pdjlStudyTime")
    @ResponseBody
    public List<Record> pdjlStudyTime(Integer u_id,Integer c_id){
        return courseService.pdjlStudyTime(u_id,c_id);
    }

    @RequestMapping("/xgStudyTime")
    @ResponseBody
    public int xgStudyTime(Integer r_id,String progress){
        System.out.println(progress);
        System.out.println(r_id);
        int i = courseService.xgStudyTime(r_id, progress);
        return i;
    }

    @RequestMapping("/getRecord")
    @ResponseBody
    public Map getRecord(String page, String limit,Integer u_id){
        System.out.println(u_id);
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        List<Record> list = courseService.getRecord(page, limit, u_id);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
}
