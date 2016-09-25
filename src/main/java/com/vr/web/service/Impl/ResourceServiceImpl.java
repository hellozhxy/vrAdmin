package com.vr.web.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.web.dao.VideoMapper;
import com.vr.web.model.Video;
import com.vr.web.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private VideoMapper videoMapper;

	@Override
	public List<Video> findVideos(Map<String, Object> params) {
		return videoMapper.findVideoByParams(params);
	}

}
