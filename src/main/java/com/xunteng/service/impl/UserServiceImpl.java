package com.xunteng.service.impl;


import com.xunteng.dao.UserDao;
import com.xunteng.pojo.User;
import com.xunteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User login(String Uname, String Upasswd) {
        User user=userDao.login(Uname,Upasswd);
        //boolean result=false;
        if (user!=null){
          return user;

        }else{
           return null;
        }

    }

    @Override
    public List<User> selectUser(Map<String, Object> map) {
        return userDao.selectUser(map);
    }


    public boolean register(User user) {
        int num = userDao.addUser(user);
        boolean result = false;
        if (num != 0) {
            result = true;
        }
        return result;
    }

    @Override
    public int removeUser(Integer id) {

        return userDao.delUser(id);
    }

   /* @Override
    public int update(String name, Integer age)
    {
        return userDao.updateStuAge(name, age);
    }*/

    @Override
    public int updateUserById(Integer id, String name,Integer age) {
        return userDao.update(id, name,age);
    }


}