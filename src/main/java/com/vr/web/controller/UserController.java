package com.vr.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.vr.web.model.UserInfo;
import com.vr.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;
  Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping
  public ModelAndView listUsers() {
    ModelAndView view = new ModelAndView("user/users");
    return view;
  }

  @RequestMapping("/getUsers")
  @ResponseBody
  public Object getUsers(@RequestParam(value="name", required=false) String name) {
    List<UserInfo> users = null;
    if(StringUtils.isBlank(name)){
      users = userService.listUsers();
    } else{
      users = userService.findUserInfoByName(name);
    }
    Map<String, Object> ret = new HashMap<String, Object>();
    ret.put("total", users.size());
    ret.put("rows", users);
    return JSON.toJSONString(ret);
  }


  @RequestMapping("addUser")
  @ResponseBody
  public void addUser(){
    
  }
  
  @RequestMapping("deleteUser")
  @ResponseBody
  public void deleteUser(){
    
  }
  
  @RequestMapping("editUser")
  @ResponseBody
  public void editUser(@RequestParam("userid") long userid){
    
  }
}
