package com.liutong.controller;

import com.liutong.model.User;
import com.liutong.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @Resource
  UserService userService;

  @RequestMapping("/test")
  @ResponseBody
  public String test(){
    return "hello world!";
  }

  @RequestMapping("/addUser")
  @ResponseBody
  public boolean addUser(User user){
    return userService.addUser(user);
  }
}
