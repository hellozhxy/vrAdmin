package com.vr.web.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

  /**
    * @Fields serialVersionUID : TODO
    */
  private static final long serialVersionUID = -469335051677768679L;

  private long userId;
  
  private String userName;
  
//  private String password;
  
//  private String passwordSalt;
  
  private String  userImgUrl;
//  用户性别0:保密,1:男,2:女
  private int userSex;
  
  private String mobile;
  
  private String email;
  
  private Date registerDate;
  
  private Date lastLoginDate;
  
  private String loginIp;
//  用户状态0:无效,1:有效
  private int status;
  
  
  

  public long getUserId() {
    return userId;
  }
  public void setUserId(long userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserImgUrl() {
    return userImgUrl;
  }
  public void setUserImgUrl(String userImgUrl) {
    this.userImgUrl = userImgUrl;
  }
  public int getUserSex() {
    return userSex;
  }
  public void setUserSex(int userSex) {
    this.userSex = userSex;
  }
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public Date getLastLoginDate() {
    return lastLoginDate;
  }
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }
  public String getLoginIp() {
    return loginIp;
  }
  public void setLoginIp(String loginIp) {
    this.loginIp = loginIp;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  
}
