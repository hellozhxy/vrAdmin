package com.vr.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vr.web.model.UserInfo;

public interface UserMapper {

  public List<UserInfo> findAllUsers();

  public UserInfo findUserInfoById(@Param("userid") long userid);

  public List<UserInfo> findUserInfoByName(@Param("name") String name);

  public int modifyUserInfo(@Param("userId") long userId, @Param("userName") String userName, 
      @Param("mobile") String mobile, @Param("email") String email);

  public int deleteUser(@Param("userId") List<Long> userids);

}
