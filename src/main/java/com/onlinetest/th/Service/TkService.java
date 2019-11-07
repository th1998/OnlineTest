package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.TkDao;
import com.onlinetest.th.Model.Question_bank;
import com.onlinetest.th.Model.Tk_stAmount_View;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TkService {
    @Resource
    TkDao tkDao;
    /*** 
    * @Description: 添加题库
    * @Param: [question_bank] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/24 
    */ 
    public int addTk(Question_bank question_bank){
        return tkDao.addTk(question_bank);
    }

    /*** 
    * @Description: 查询题库所以信息
    * @Param: [] 
    * @return: java.util.List<com.onlinetest.th.Model.Question_bank> 
    * @Author: Tanghao 
    * @Date: 2019/10/24 
    */ 
    public List<Question_bank> getQuestion_bank(){
        return tkDao.getQuestion_bank();
    }

    /***
    * @Description: 根据题库和试题的视图查询，得到题库信息列表
    * @Param: []
    * @return: java.util.List<com.onlinetest.th.Model.Tk_st_View>
    * @Author: Tanghao
    * @Date: 2019/10/27
    */
    public List<Tk_stAmount_View> getTk_st_View(String page, String limit){
        return tkDao.getTk_st_View();
    }
}
