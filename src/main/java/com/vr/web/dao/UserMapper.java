package com.vr.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vr.web.model.UserInfo;

public interface UserMapper {

  public List<UserInfo> findAllUsers();

  public UserInfo findUserInfoById(@Param("userid") long userid);

}
