package com.vr.web.model;

import java.io.Serializable;

public class PermissionInfo implements Serializable {

  /**
    * @Fields serialVersionUID : TODO
    */
  private static final long serialVersionUID = 4824988874005681632L;

  private long permissionId;
  
  private String permissionName;

  public long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(long permissionId) {
    this.permissionId = permissionId;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }
  
  
}
