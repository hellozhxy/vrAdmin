package com.vr.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vr.web.model.Video;
import com.vr.web.model.VideoCategory;
import com.vr.web.service.ResourceCategoryService;
import com.vr.web.service.ResourceService;

/**
 * Description:视频后台管理 
 * All Rights Reserved.
 * @version 1.0  2016年9月25日 上午10:45:23  by 代鹏（daipeng.456@gmail.com）创建
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
	
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
	  public ModelAndView listUsers() {
		ModelAndView view = new ModelAndView("resource/resources");
		List<VideoCategory> videoCategorys = resourceCategoryService.findValidVideoCategorys();
		view.addObject("videoCategorys", videoCategorys);
	    return view;
	  }
	
	@RequestMapping(value="/listResources", method ={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView listResources(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("resource/listResource");
	    List<Video> videos = resourceService.findAllVideos();
	    view.addObject("videos", videos);
	    return view;
	}
  
}
