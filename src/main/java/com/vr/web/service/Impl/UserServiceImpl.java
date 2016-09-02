package com.vr.web.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.web.dao.UserMapper;
import com.vr.web.model.UserInfo;
import com.vr.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserMapper userMapper;
  private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  
  @Override
  public List<UserInfo> listUsers() {
    return userMapper.findAllUsers();
  }

  @Override
  public UserInfo findUserInfoById(long userid) {
    return userMapper.findUserInfoById(userid);
  }

}
