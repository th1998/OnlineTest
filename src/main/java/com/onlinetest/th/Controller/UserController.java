package com.onlinetest.th.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onlinetest.th.Model.ResultMsg;
import com.onlinetest.th.Model.User;
import com.onlinetest.th.Model.pageBean;
import com.onlinetest.th.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*** 
    * @Description: 添加用户
    * @Param: [user] 
    * @return: com.onlinetest.th.Model.ResultMsg 
    * @Author: Tanghao 
    * @Date: 2019/10/23 
    */ 
    @RequestMapping("/addUser")
    @ResponseBody
    public ResultMsg addUser(User user){
        User u = new User();
        u.setUserName(user.getUserName());
        u.setUserPass(user.getUserPass());
        u.setUserNo(user.getUserNo());
        u.setUserClass(user.getUserClass());
        u.setUserRole(user.getUserRole());
        int i = userService.addUser(u);
        if(i>0){
            return new ResultMsg(1,"添加用户成功");
        }else{
            return new ResultMsg(1,"添加用户失败");
        }
    }

    /***
    * @Description:  查询用户
    * @Param: []
    * @return: int
    * @Author: Tanghao
    * @Date: 2019/10/23
    */
    @RequestMapping("/getAllUser")
    @ResponseBody
    public Map allUser(String page, String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        List<User> users = userService.getAllUser(page,limit);
        PageInfo pageInfo = new PageInfo(users);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }

    /*** 
    * @Description: 删除用户 
    * @Param: [id] 
    * @return: com.onlinetest.th.Model.ResultMsg 
    * @Author: Tanghao 
    * @Date: 2019/10/28 
    */ 
    @RequestMapping("/delUser")
    @ResponseBody
    public ResultMsg delUser(Integer id){
        int i = userService.delUser(id);
        if(i>0){
            return new ResultMsg(1,"删除用户成功");
        }else{
            return new ResultMsg(1,"删除用户失败");
        }
    }
    
    /*** 
    * @Description: 修改用户
    * @Param: [u] 
    * @return: com.onlinetest.th.Model.ResultMsg 
    * @Author: Tanghao 
    * @Date: 2019/10/28 
    */ 
    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultMsg updateUser(User u){
        User user = new User();
        user.setId(u.getId());
        user.setUserName(u.getUserName());
        user.setUserNo(u.getUserNo());
        user.setUserPass(u.getUserPass());
        user.setUserClass(u.getUserClass());
        int i = userService.updateUser(user);
        if(i>0){
            return new ResultMsg(1,"修改信息成功");
        }else{
            return new ResultMsg(1,"修改信息失败");
        }
    }

    /*** 
    * @Description: 根据id查询用户 
    * @Param: [id] 
    * @return: java.util.List<com.onlinetest.th.Model.User> 
    * @Author: Tanghao 
    * @Date: 2019/11/1 
    */ 
    @RequestMapping("/findUserId")
    @ResponseBody
    public List<User> findUserId(Integer id){
        return userService.findUserId(id);
    }
}
