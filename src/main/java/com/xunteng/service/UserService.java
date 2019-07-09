package com.xunteng.service;


import com.xunteng.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> selectUser(Map<String,Object> map);
    public User login(String Uname, String Upasswd);
    public int removeUser(Integer id);
    public int updateUserById(Integer id, String name,Integer age);
    public boolean register(User user);
    public boolean exist (String name);
}
