package com.vr.web.service;

import java.util.List;

import com.vr.web.model.PermissionInfo;

public interface PermissionService {

  public List<PermissionInfo> listPermission();

  public boolean addPermission(String name);

  public List<PermissionInfo> findPermission(String name);


}
