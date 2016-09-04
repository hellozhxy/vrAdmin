package com.vr.web.controller;

import java.util.List;

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


  @RequestMapping("listUsers")
//  public ModelAndView listUsers() {
  public ModelAndView listUsers(){
    List<UserInfo> users = userService.listUsers();
    logger.info(JSON.toJSONString(users));
    ModelAndView view = new ModelAndView("user/listUser");
    view.addObject("rows", users);
    return view;
  }

  @RequestMapping("findUser")
  @ResponseBody
  public UserInfo getUserInfo(@RequestParam("userid") long userid) {
    return userService.findUserInfoById(userid);
  }
}
