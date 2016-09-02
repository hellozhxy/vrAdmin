package com.vr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("menu")
public class MenuController {

  @RequestMapping
  public String home(){
    return "index";
  }
  
  @RequestMapping("index")
  public String index(){
    return "index";
  }
  
  @RequestMapping("user")
  public String user(){
    return "user/listUser";
  }
  
  @RequestMapping("role")
  public String role(){
    return "role";
  }
}
