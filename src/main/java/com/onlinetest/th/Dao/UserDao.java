package com.onlinetest.th.Dao;

import com.onlinetest.th.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /*** 
    * @Description: 添加用户
    * @Param: [user] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/23 
    */
    @Insert("insert into user(UserName,UserPass,UserNo,UserClass,UserRole)" +
            "values(#{UserName},#{UserPass},#{UserNo},#{UserClass},#{UserRole})")
    public int addUser(User user);

    /***
    * @Description: 查询用户显示列表
    * @Param: []
    * @return: java.util.List<com.onlinetest.th.Model.User>
    * @Author: Tanghao
    * @Date: 2019/10/28
    */
    @Select("select * from user ORDER BY UserRole desc")
    public List<User> getAllUser();

    /*** 
    * @Description: 删除用户
    * @Param: [id] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/28 
    */ 
    @Delete("delete from user where id = #{id}")
    public int delUser(Integer id);

    /*** 
    * @Description: 修改用户
    * @Param: [u] 
    * @return: int 
    * @Author: Tanghao 
    * @Date: 2019/10/28 
    */ 
    @Update("update user set UserName = #{UserName},UserPass = #{UserPass},UserNo = #{UserNo},UserClass = #{UserClass} where id = #{id}")
    public int updateUser(User u);

    /*** 
    * @Description: 根据id查询用户 
    * @Param: [id] 
    * @return: java.util.List<com.onlinetest.th.Model.User> 
    * @Author: Tanghao 
    * @Date: 2019/11/1 
    */ 
    @Select("select * from user where id =#{id}")
    public List<User> findUserId(Integer id);
}
