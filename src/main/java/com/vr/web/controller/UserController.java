package com.vr.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vr.web.model.UserInfo;
import com.vr.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;
  Logger logger = LoggerFactory.getLogger(UserController.class);


  @RequestMapping("listUsers")
  public ModelAndView listUsers(){
//    List<UserInfo> users = userService.listUsers();
//    logger.info(JSON.toJSONString(users));
    ModelAndView view = new ModelAndView("user/users");
//    view.addObject("total", users.size());
//    view.addObject("rows", users);
    return view;
  }
  
  @RequestMapping("getUsers")
  @ResponseBody
  public Object getUsers(){
    List<UserInfo> users = userService.listUsers();
    List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
    for(UserInfo user : users){
      Map<String, Object> result = new HashMap<String, Object>();
      result.put("userName", user.getUserName());
      result.put("loginIp", user.getLoginIp());
      results.add(result);
    }
    Map<String, Object> ret = new HashMap<String, Object>();
    ret.put("total", results.size());
    ret.put("rows", results);
    return net.sf.json.JSONObject.fromObject(ret);
  }

  @RequestMapping("findUser")
  @ResponseBody
  public UserInfo getUserInfo(@RequestParam("userid") long userid) {
    return userService.findUserInfoById(userid);
  }
}
