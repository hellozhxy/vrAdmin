package com.vr.web.service;

import java.util.List;

import com.vr.web.model.VideoCategory;

/**
 * Description: 视频分类service
 * All Rights Reserved.
 * @version 1.0  2016年9月25日 上午10:40:37  by 代鹏（daipeng.456@gmail.com）创建
 */
public interface ResourceCategoryService {
	
	/**
	 * Description: 获取有效视频分类
	 * @Version1.0 2016年9月25日 上午10:40:50 by 代鹏（daipeng.456@gmail.com）创建
	 * @return
	 */
	List<VideoCategory> findValidVideoCategorys();

}
