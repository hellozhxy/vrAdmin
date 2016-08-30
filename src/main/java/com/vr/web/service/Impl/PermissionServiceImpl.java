package com.vr.web.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.web.dao.PermissionMapper;
import com.vr.web.model.PermissionInfo;
import com.vr.web.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

  @Autowired
  private PermissionMapper permissionMapper;
  Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

  @Override
  public List<PermissionInfo> listPermission() {
    return permissionMapper.findAllPermission();
  }

  @Override
  public boolean addPermission(String name) {
    return permissionMapper.addPermission(name);
  }

  @Override
  public List<PermissionInfo> findPermission(String name) {
    // TODO Auto-generated method stub
    return permissionMapper.findPermission(name);
  }


}
