package com.onlinetest.th.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onlinetest.th.Model.Question_bank;
import com.onlinetest.th.Model.ResultMsg;
import com.onlinetest.th.Model.Tk_stAmount_View;
import com.onlinetest.th.Service.TkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
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
public class TkController {

    @Autowired
    private TkService tkService;
    
    /*** 
    * @Description: 添加题库
    * @Param: [file, request] 
    * @return: java.lang.String 
    * @Author: Tanghao 
    * @Date: 2019/10/24 
    */ 
    @RequestMapping("/addTk")
    @ResponseBody
    public ResultMsg upload_submit(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request) throws IOException, ParseException {
        String tkName = request.getParameter("tkName");
        String tkStatus = request.getParameter("tkStatus");
        Integer tkstatus = Integer.valueOf(tkStatus);
        String tkExplain = request.getParameter("tkExplain");


        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();//文件集合

        //String path ="D:\\idea\\test\\imag";
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"public/images/upload/");
        if(!upload.exists()) upload.mkdirs();
        String realPath = upload.getAbsolutePath();
        System.out.println("upload url:"+upload.getAbsolutePath());



        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = sj.format(new Date());

            SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");
            String date=df2.format(new Date());
            System.out.println(date + "当前时间");

            MultipartFile file2 = entity.getValue();
            System.out.println(file2);
            String filename = file2.getOriginalFilename();

            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 扩展名
            String fileExt = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();//扩展名
            Date date2=df2.parse(date);
            //新的文件名
            String newFileName=date+"_"+new Random().nextInt(100)+"."+fileExt;
            System.out.println("新文件名："+newFileName);
            //保存的路径
            String Savepath="/imag/"+newFileName;
            System.out.println("存储路径"+Savepath);
            String aaa = realPath+"\\"+newFileName;
            System.out.println("我测试的1："+aaa);
            aaa = aaa.replaceAll("\\\\", "/");
            System.out.println("我测试的1："+aaa);
            //保存图片数据
            //将上传的文件保存到目标文件中
            File ff = new File(aaa);
            file2.transferTo(ff);
            //图片url
            String url = "/upload/"+newFileName;
            System.out.println(path+File.separator+filename);

            Question_bank q = new Question_bank();
            q.setTk_name(tkName);
            q.setTk_pic(url);
            q.setTk_status(tkstatus);
            q.setTk_explain(tkExplain);
            q.setTk_dateTime(dateTime);
            int i = tkService.addTk(q);
            if(i>0){
                return new ResultMsg(1,"题库添加成功");
            }
        }


        return new ResultMsg(1,"题库添加失败");
    }

    /*** 
    * @Description: 查询题库所以信息
    * @Param: [] 
    * @return: java.util.List<com.onlinetest.th.Model.Question_bank> 
    * @Author: Tanghao 
    * @Date: 2019/10/24 
    */ 
    @RequestMapping("/getQuestion_bank")
    @ResponseBody
    public List<Question_bank> getQuestion_bank(){
        List<Question_bank> list= tkService.getQuestion_bank();
        return list;
    }
    
    /*** 
    * @Description: 根据题库和试题的视图查询，得到题库信息列表
    * @Param: [] 
    * @return: java.util.List<com.onlinetest.th.Model.Tk_st_View> 
    * @Author: Tanghao 
    * @Date: 2019/10/27 
    */ 
    @RequestMapping("/getTk_st_View")
    @ResponseBody
    public Map getTk_st_View(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        List<Tk_stAmount_View> list = tkService.getTk_st_View(page,limit);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
}
