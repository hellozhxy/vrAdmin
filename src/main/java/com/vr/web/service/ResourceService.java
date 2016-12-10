package com.vr.web.service;

import java.util.List;
import java.util.Map;

import com.vr.web.model.Video;
import com.vr.web.vo.VideoVo;

public interface ResourceService {
	
	/**
	 * Description: 查找视频资源
	 * @Version1.0 2016年12月4日 上午10:16:32 by 代鹏（daipeng.456@gmail.com）创建
	 * @param params
	 * @return
	 */
	List<VideoVo> findVideos(Map<String, Object> params);
	
	/**
	 * Description: 获取视频资源总数
	 * @Version1.0 2016年12月4日 上午10:16:45 by 代鹏（daipeng.456@gmail.com）创建
	 * @param params
	 * @return
	 */
	Long findVideoCount(Map<String, Object> params);
	
	/**
	 * Description: 根据videoId获取视频资源
	 * @Version1.0 2016年12月10日 下午12:16:23 by 代鹏（daipeng.456@gmail.com）创建
	 * @param videoId
	 * @return
	 */
	Video findVideoById(Long videoId);
	
	/**
	 * Description: 更新video
	 * @Version1.0 2016年12月10日 下午12:19:10 by 代鹏（daipeng.456@gmail.com）创建
	 * @param video
	 * @return
	 */
	int updateVideo(Video video);

}
