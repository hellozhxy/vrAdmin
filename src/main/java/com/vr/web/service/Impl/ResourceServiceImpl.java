package com.vr.web.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vr.web.dao.VideoMapper;
import com.vr.web.model.Video;
import com.vr.web.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	
	private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
	
	private VideoMapper videoMapper;

	@Override
	public List<Video> findAllVideos() {
		try {
			return videoMapper.findAllVideos();
		} catch (Exception e) {
			logger.error("ResourceServiceImpl_findAllVideos_invoke_error:", e);
		}
		return new ArrayList<Video>();
	}

}
