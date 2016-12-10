package com.vr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description: admin配置加载
 * All Rights Reserved.
 * @version 1.0  2016年12月4日 下午8:39:40  by 代鹏（daipeng.456@gmail.com）创建
 */
@Component("adminConfig")
public class AdminConfig {
	
	/**
	 * 文件上传目录
	 */
	@Value(value = "${upload_resource_dir}")
	private String uploadDir;
	
	@Value(value = "${video_file_suffix}")
	private String videoFileSuffix;

	public String getUploadDir() {
		return uploadDir;
	}

	public String getVideoFileSuffix() {
		return videoFileSuffix;
	}
	
}
