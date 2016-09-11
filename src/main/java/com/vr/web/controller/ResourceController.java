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
import com.vr.web.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="listResources", method ={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView listResources(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("resource/listResource");
	    List<Video> videos = resourceService.findAllVideos();
	    view.addObject("videos", videos);
	    return view;
	}
  
}
