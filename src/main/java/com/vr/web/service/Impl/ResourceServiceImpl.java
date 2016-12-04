package com.vr.web.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vr.utils.ToolsUtil;
import com.vr.web.dao.UserMapper;
import com.vr.web.dao.VideoCategoryMapper;
import com.vr.web.dao.VideoMapper;
import com.vr.web.model.UserInfo;
import com.vr.web.model.Video;
import com.vr.web.model.VideoCategory;
import com.vr.web.service.ResourceService;
import com.vr.web.vo.VideoVo;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private VideoMapper videoMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private VideoCategoryMapper videoCategoryMapper;

	@Override
	public List<VideoVo> findVideos(Map<String, Object> params) {
		List<Video> videos = videoMapper.findVideoByParams(params);
		if(CollectionUtils.isNotEmpty(videos)){
			Set<Long> userIds = Sets.newHashSet();
			Set<Long> categoryIds = Sets.newHashSet();
			for(Video video:videos){
				if(null != video.getUserId()){
					userIds.add(video.getUserId());
				}
				if(null != video.getCategoryId()){
					categoryIds.add(video.getCategoryId());
				}
			}
			List<UserInfo> users = userMapper.findUsersByUserIds(userIds);
			Map<Long, UserInfo> userMap = Maps.newHashMap();
			for(UserInfo user:users){
				userMap.put(user.getUserId(), user);
			}
			
			List<VideoCategory> categorys = videoCategoryMapper.findVideoCategoryByParams(ToolsUtil.builderMapParams("categoryIds", categoryIds));
			Map<Long, VideoCategory> categoryMap = Maps.newHashMap();
			for(VideoCategory category:categorys){
				categoryMap.put(category.getId(), category);
			}
			
			List<VideoVo> vos = Lists.newArrayList();
			for(Video video:videos){
				VideoVo vo = new VideoVo();
				BeanUtils.copyProperties(video, vo);
				UserInfo user = userMap.get(video.getUserId());
				if(null != user){
					vo.setUserNickName(user.getUserNickName());
				}
				
				VideoCategory category = categoryMap.get(video.getCategoryId());
				if(null != category){
					vo.setCategoryName(category.getCategoryName());
				}
				vos.add(vo);
			}
			return vos;
		}
		return new ArrayList<VideoVo>();
	}

	@Override
	public Long findVideoCount(Map<String, Object> params) {
		return videoMapper.findVideoCount(params);
	}

}
