package com.xunteng.controller;


import com.mysql.jdbc.StringUtils;
import com.xunteng.pojo.User;
import com.xunteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/selectUserAsJson")
    public List<User> selectUserAsJson(String id) {
        List<User> users = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        users = userService.selectUser(map);
        return users;
    }

    @RequestMapping(value = "/selectUserAsJsp")
    public ModelAndView selectUserAsJsp(String id) {
        List<User> users = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        users = userService.selectUser(map);
        ModelAndView model = new ModelAndView();
        model.addObject("users", users);
        model.setViewName("index");  //不是页面名称，逻辑名称   相当于： /views/index.jsp
        return model;
    }



    @RequestMapping("/regist")
     public String RegistUser(@RequestParam("name") String name, @RequestParam("age") Integer age,
                              @RequestParam("id") Integer id) {
        System.out.println(name);
        User user=new User();
        user.setAge(age);
        user.setId(id);
        user.setName(name);
     boolean a=userService.register(user);
        System.out.println(a);

      // return "login";
        return ("redirect:/user/selectUserAsJsp");
    }
    @RequestMapping("/test")
    public String test() {

        return "index3";

    }

    @RequestMapping("/delete")
    public String  delUser(Integer id){

      int num=userService.removeUser(id);
        if (num==1) {
            return "redirect:/user/selectUserAsJsp";
        }else{
           return "error";
        }





    }
    @RequestMapping("/update")
    public String  updateUser(@RequestParam Integer id,@RequestParam String name,
                              @RequestParam Integer age){
      /*  User user=new User();
        user.setName(name);
        user.setId(id);
        user.setAge(age);*/
      int num=userService.updateUserById(id ,name,age);
        if (num==1) {
            return "redirect:/user/selectUserAsJsp";
        }else{
            return "error";//逻辑视图名
        }

}
public String doLogin(@RequestParam Integer id, @RequestParam String name,
                      @RequestParam String passwd , HttpSession session ,  HttpServletRequest request){
   User user=userService.login(name,passwd);
    if (user !=null){  //如果用户存在
        session.setAttribute("user",user);
        return ("redirect:/user/selectUserAsJsp");
    }else{
        //用户名或密码错误，用户不存在

        request.setAttribute("message", "用胡不存在");
        return "login";  //重新返回到登录页面
    }

}
//退出登录
@RequestMapping("/loginOut")
public String loginout(HttpSession session){
        session.removeAttribute("user");//清空session

     return "login";
}
//用户名是否被占用
    @RequestMapping("/isExist")
    @ResponseBody
    public Object isExist(@RequestParam String name){

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(name)){
            resultMap.put("Uname", "exist");
        }else{
            boolean result=userService.exist(name);
            if(result)
                resultMap.put("userCode", "exist");
            else
                resultMap.put("userCode", "noexist");
        }
       // return JSONArray.toJSONString(resultMap);
         return aaa

    }
}