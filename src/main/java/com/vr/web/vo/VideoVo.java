package com.vr.web.vo;

import java.io.Serializable;

import com.vr.web.model.Video;

/**
 * Description: 视频列表Vo
 * All Rights Reserved.
 * @version 1.0  2016年12月4日 上午10:59:16  by 代鹏（daipeng.456@gmail.com）创建
 */
public class VideoVo extends Video implements Serializable {

	private static final long serialVersionUID = 6008686951905849094L;
	
	private String userNickName;
	
	private String categoryName;
	
	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
