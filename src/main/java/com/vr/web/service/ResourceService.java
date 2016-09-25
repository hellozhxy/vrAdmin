package com.vr.web.service;

import java.util.List;
import java.util.Map;

import com.vr.web.model.Video;

public interface ResourceService {
	
	List<Video> findVideos(Map<String, Object> params);

}
