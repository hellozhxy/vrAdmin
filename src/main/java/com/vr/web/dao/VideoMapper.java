package com.vr.web.dao;

import java.util.List;
import java.util.Map;

import com.vr.web.model.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
    
    List<Video> findVideoByParams(Map<String, Object> params);
    
    List<Video> findAllVideos();
}