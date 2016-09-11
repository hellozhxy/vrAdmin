package com.vr.web.dao;

import java.util.List;
import java.util.Map;

import com.vr.web.model.VideoCategory;

public interface VideoCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(VideoCategory record);

    int insertSelective(VideoCategory record);

    VideoCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VideoCategory record);

    int updateByPrimaryKey(VideoCategory record);
    
    List<VideoCategory> findVideoCategoryByParams(Map<String, Object> params);
}