package com.vr.web.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.utils.ToolsUtil;
import com.vr.web.dao.VideoCategoryMapper;
import com.vr.web.model.VideoCategory;
import com.vr.web.service.ResourceCategoryService;

@Service("resourceCategoryService")
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
	
	@Autowired
	private VideoCategoryMapper videoCategoryMapper;

	@Override
	public List<VideoCategory> findValidVideoCategorys() {
		return videoCategoryMapper.findVideoCategoryByParams(ToolsUtil.builderMapParams("status", 1));
	}

}
