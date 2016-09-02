package com.vr.web.service;

import java.util.List;

import com.vr.web.model.UserInfo;

public interface UserService {

  public List<UserInfo> listUsers();

  public UserInfo findUserInfoById(long userid);
  

}
