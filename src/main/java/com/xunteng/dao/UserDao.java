package com.xunteng.dao;


import com.xunteng.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> selectUser(Map<String, Object> map);


    //实现添加用户
    public int addUser(User user);

    //根据ID删除用户
    public int delUser(Integer id);
    //根据用户名修改用户年龄
    // public int  updateStuAge(String name,Integer age);

    //根据用户ID进行修改用户信息
    public int update(@Param("id") Integer id, @Param("name") String name,
                      @Param("age") Integer age);

    //添加     登录方法   chaxun
    public User login(@Param("Uname") String Uname, @Param("Upasswd") String Upasswd);

    //如果参数是对象

    public User login2(User user);

    //查询用户名是否已经存在存在   --新添加
    public User exist(String Uname);


}
