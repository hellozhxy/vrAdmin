package com.vr.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vr.web.model.RoleInfo;
import com.vr.web.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

  @Autowired
  private RoleService roleService;
  private Logger logger = LoggerFactory.getLogger(RoleController.class);
  
  @RequestMapping("listRoles")
  public ModelAndView listRoles(){
    ModelAndView view = new ModelAndView("role/listRoles");
    List<RoleInfo> roles = roleService.findAllRoles();
    view.addObject("roles", roles);
    return view;
  }
}
