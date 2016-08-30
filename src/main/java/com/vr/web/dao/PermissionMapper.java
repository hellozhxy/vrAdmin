package com.vr.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vr.web.model.PermissionInfo;

public interface PermissionMapper {

  List<PermissionInfo> findAllPermission();

  boolean addPermission(@Param("name") String name);

  List<PermissionInfo> findPermission(@Param("name") String name);

}
