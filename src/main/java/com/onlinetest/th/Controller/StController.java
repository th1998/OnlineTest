package com.onlinetest.th.Controller;

import com.onlinetest.th.Model.ResultMsg;
import com.onlinetest.th.Model.Test_question;
import com.onlinetest.th.Service.StService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StController {
    @Autowired
    private StService stService;

    /*** 
    * @Description: 添加试题
    * @Param: [tq] 
    * @return: com.onlinetest.th.Model.ResultMsg 
    * @Author: Tanghao 
    * @Date: 2019/10/25 
    */ 
    @RequestMapping("/addSt")
    @ResponseBody
    public ResultMsg addSt(Test_question tq){
        Test_question T_q = new Test_question();
        T_q.setTk_id(tq.getTk_id());
        T_q.setSt_type(tq.getSt_type());
        T_q.setSt_question(tq.getSt_question());
        T_q.setSt_a(tq.getSt_a());
        T_q.setSt_b(tq.getSt_b());
        T_q.setSt_c(tq.getSt_c());
        T_q.setSt_d(tq.getSt_d());
        T_q.setSt_t(tq.getSt_t());
        T_q.setSt_f(tq.getSt_f());
        T_q.setSt_answer(tq.getSt_answer());
        T_q.setSt_analyze(tq.getSt_analyze());

        int i = stService.addSt(T_q);
        if(i>0){
            return new ResultMsg(1,"试题添加成功");
        }
        return new ResultMsg(1,"试题添加失败");
    }
}
