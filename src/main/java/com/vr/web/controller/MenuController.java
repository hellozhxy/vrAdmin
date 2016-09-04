package com.vr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

  
  @RequestMapping("index")
  public String index(){
    return "index";
  }
  
  @RequestMapping("role")
  public String role(){
    return "role";
  }
}
