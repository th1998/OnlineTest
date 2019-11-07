package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.UserDao;
import com.onlinetest.th.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
    * @Description:  添加用户
    * @Param: [user]
    * @return: int
    * @Author: Tanghao
    * @Date: 2019/10/23
    */
    public int addUser(User user){
        return userDao.addUser(user);
    }

    /***
    * @Description:  查询用户显示列表
    * @Param: [page, limit]
    * @return: java.util.List<com.onlinetest.th.Model.User>
    * @Author: Tanghao
    * @Date: 2019/10/28
    */
    public List<User> getAllUser(String page,String limit){
        return userDao.getAllUser();
    }

    /***
    * @Description:  删除用户
    * @Param: [id]
    * @return: int
    * @Author: Tanghao
    * @Date: 2019/10/28
    */
    public int delUser(Integer id){
        return userDao.delUser(id);
    }

    /*** 
    * @Description: 修改用户
    * @Param: [u] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/28 
    */ 
    public int updateUser(User u){
        return userDao.updateUser(u);
    }

    /*** 
    * @Description: 根据id查询用户 
    * @Param: [id] 
    * @return: java.util.List<com.onlinetest.th.Model.User> 
    * @Author: Tanghao 
    * @Date: 2019/11/1 
    */ 
    public List<User> findUserId(Integer id){return  userDao.findUserId(id);}
}
