package com.vr.web.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.web.dao.RoleMapper;
import com.vr.web.model.RoleInfo;
import com.vr.web.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleMapper roleMapper;
  private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
  
  
  @Override
  public List<RoleInfo> findAllRoles() {
    return roleMapper.findAllRoles();
  }
  
  
}
