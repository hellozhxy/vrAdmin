package com.vr.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vr.utils.ToolsUtil;
import com.vr.web.model.Video;
import com.vr.web.model.VideoCategory;
import com.vr.web.service.ResourceCategoryService;
import com.vr.web.service.ResourceService;
import com.vr.web.view.JaxbJsonView;

/**
 * Description:视频后台管理 
 * All Rights Reserved.
 * @version 1.0  2016年9月25日 上午10:45:23  by 代鹏（daipeng.456@gmail.com）创建
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private ResourceCategoryService resourceCategoryService;
	
	/**
	 * Description: 视频管理
	 * @Version1.0 2016年9月25日 上午10:48:29 by 代鹏（daipeng.456@gmail.com）创建
	 * @return
	 */
	@RequestMapping
	public ModelAndView listResource() {
		ModelAndView view = new ModelAndView("resource/resources");
		List<VideoCategory> videoCategorys = resourceCategoryService.findValidVideoCategorys();
		view.addObject("videoCategorys", videoCategorys);
		return view;
	}
	
	/**
	 * Description: 视频管理列表
	 * @Version1.0 2016年12月4日 上午10:04:19 by 代鹏（daipeng.456@gmail.com）创建
	 * @param request
	 * @param response
	 * @param title
	 * @param categoryId
	 * @param status
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getVideos", method ={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView getVideos(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="title", required=false)String title,
			@RequestParam(value="categoryId", required=false)Long categoryId,
			@RequestParam(value="status", required=false)Integer status,
			@RequestParam(value="page", required=false)Integer page,
			@RequestParam(value="rows", required=false)Integer rows){
		 Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("offSet", (null != page && page >=1)?(page-1)*rows:1);
			params.put("pageSize", rows);
			params.put("title", title);
			params.put("categoryId", categoryId);
			params.put("status", status);
			List<Video> videos = resourceService.findVideos(params);
			ret.put("total", resourceService.findVideoCount(ToolsUtil.builderMapParams("title", title, "categoryId", categoryId, "status", status)));
		    ret.put("rows", videos);
		} catch (Exception e) {
			logger.error(String.format("ResourceController_getVideos_error: title:%s, categoryId:%s, status:%s, page:%s, rows:%s", 
					title, categoryId, status, page, rows), e);
		}
		return new ModelAndView(new JaxbJsonView(ret));
	}
	
}
