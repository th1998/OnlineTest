package com.onlinetest.th.Controller;

import com.onlinetest.th.Model.User;
import com.onlinetest.th.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public List<User> login(String UserName, String UserPass, HttpSession session){
        if(UserName != null){
            session.setAttribute("USER", UserName);
            //System.out.println(session.getAttribute("USER"));
        }
        List<User> list = loginService.login(UserName,UserPass);
        return list;
    }
}
