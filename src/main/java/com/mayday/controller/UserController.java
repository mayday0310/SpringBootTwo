package com.mayday.controller;

import com.mayday.config.MyConfigProperties;
import com.mayday.model.UserModel;
import com.mayday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户控制层
 */
@Controller
public class UserController {



    @RequestMapping(value="/index")
    public String index(){
        return "login";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private MyConfigProperties myConfigProperties;

    @RequestMapping(value="/addUser")
        public String addUser(Map<String,Object> map, String userName, String password){
        UserModel user=new UserModel(5,userName,password);
        userService.addUser(user);
        map.put("message","增加成功！");
        return "/userAdd";

    }
    @ResponseBody
    @RequestMapping("/queryUser")
    public UserModel query(){
        //通过@ConfigurationProperties注解获取配置文件中的属性
        System.out.println("======================="+myConfigProperties.getUsername());
       UserModel userModel= userService.queryUser(1l);
        return userModel;

    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String userLogin(HttpServletRequest request,String userName,String password){


        return "index";
    }



}
