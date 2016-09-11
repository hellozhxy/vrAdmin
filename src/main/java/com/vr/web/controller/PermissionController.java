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

import com.vr.web.model.PermissionInfo;
import com.vr.web.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

  @Autowired
  private PermissionService permissionService;
  private Logger logger = LoggerFactory.getLogger(PermissionController.class);

  @RequestMapping(value = "/addPermission")
  public ModelAndView addPermission(@RequestParam("permissionId") long id,
      @RequestParam("permissionName") String name) {
    boolean ret = permissionService.addPermission(name);
    return new ModelAndView("permission/addPermission");
  }

  @RequestMapping("/listPermission")
  @ResponseBody
  public List<PermissionInfo> listPermission() {
    return permissionService.listPermission();
  }

  @RequestMapping("/findPermission")
  @ResponseBody
  public List<PermissionInfo> findPermission(@RequestParam("permissionName") String name) {
    return permissionService.findPermission(name);
  }
}
