package com.vr.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vr.web.model.UserInfo;
import com.vr.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("listUsers")
	@ResponseBody
	public List<UserInfo> listUsers(){
	  return userService.listUsers();
	}

	@RequestMapping("findUser")
	@ResponseBody
	public UserInfo getUserInfo(@RequestParam("userid") long userid){
	  return userService.findUserInfoById(userid);
	}
}
