package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.LoginDao;
import com.onlinetest.th.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {
    @Resource
    private LoginDao loginDao;

    /** 
    * @Description: 登录方法
    * @Param: [UserName, UserPass] 
    * @return: list
    * @Author: Tanghao 
    * @Date: 2019/10/21 
    */ 
    public List<User> login(String UserName, String UserPass){
        return loginDao.login(UserName,UserPass);
    }
}
