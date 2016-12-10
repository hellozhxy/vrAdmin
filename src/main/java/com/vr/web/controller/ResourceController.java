package com.vr.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vr.config.AdminConfig;
import com.vr.enums.ErrorCodeEnum;
import com.vr.utils.DateUtil;
import com.vr.utils.ToolsUtil;
import com.vr.utils.UploadUtils;
import com.vr.web.model.Video;
import com.vr.web.model.VideoCategory;
import com.vr.web.service.ResourceCategoryService;
import com.vr.web.service.ResourceService;
import com.vr.web.upload.ResumableInfo;
import com.vr.web.upload.ResumableInfoStorage;
import com.vr.web.view.JaxbJsonView;
import com.vr.web.vo.MessageVo;
import com.vr.web.vo.VideoVo;

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
	
	@Autowired
	private AdminConfig adminConfig;
	
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
	
	@ResponseBody
	@RequestMapping(value="/videoCategorys", method ={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView categorys() {
		List<VideoCategory> videoCategorys = resourceCategoryService.findValidVideoCategorys();
		return new ModelAndView(new JaxbJsonView(videoCategorys));
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
			List<VideoVo> videos = resourceService.findVideos(params);
			ret.put("total", resourceService.findVideoCount(ToolsUtil.builderMapParams("title", title, "categoryId", categoryId, "status", status)));
		    ret.put("rows", videos);
		} catch (Exception e) {
			logger.error(String.format("ResourceController_getVideos_error: title:%s, categoryId:%s, status:%s, page:%s, rows:%s", 
					title, categoryId, status, page, rows), e);
		}
		return new ModelAndView(new JaxbJsonView(ret));
	}
	
	@ResponseBody
	@RequestMapping(value="/updateVideo", method ={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView updateVideo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="videoId", required=true)Long videoId){
		try {
			Video video = resourceService.findVideoById(videoId);
			if(null == video){
				return new ModelAndView(new JaxbJsonView(new MessageVo<Video>(false, ErrorCodeEnum.ERROR_10001.getCode(), ErrorCodeEnum.ERROR_10001.getMsg())));
			}
			System.out.println(request.getParameter("categoryName"));
			
			video.setCategoryId(Long.valueOf(request.getParameter("categoryName")));
			video.setTitle(request.getParameter("title"));
			video.setDescription(request.getParameter("description"));
			video.setKeywords(request.getParameter("keywords"));
			video.setPlayTimes(Integer.valueOf(request.getParameter("playTimes")));
			video.setPublishTime(DateUtil.toDate(request.getParameter("publishTime")));
			resourceService.updateVideo(video);
			return new ModelAndView(new JaxbJsonView(new MessageVo<Video>(true, video)));
		} catch (Exception e) {
			logger.error("updateVideo_invoke_error.....", e);
		}
		return new ModelAndView(new JaxbJsonView(new MessageVo<Video>(false, ErrorCodeEnum.ERROR_10002.getCode(), ErrorCodeEnum.ERROR_10002.getMsg())));
	}
	
	
	
	/**
	 * Description: 文件资源上传
	 * @Version1.0 2016年12月4日 下午8:36:35 by 代鹏（daipeng.456@gmail.com）创建
	 * @param request
	 * @param response
	 * @throws IllegalAccessException 
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/upload", method ={RequestMethod.POST, RequestMethod.GET})
	public void upload(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException{
		String method = request.getMethod();
		if(HttpGet.METHOD_NAME.equals(method)){
			int resumableChunkNumber = getResumableChunkNumber(request);

			ResumableInfo info = getResumableInfo(request);

			if (info.uploadedChunks.contains(new ResumableInfo.ResumableChunkNumber(resumableChunkNumber))) {
				response.getWriter().print("Uploaded."); // This Chunk has been Uploaded.
			} else {
				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			}
		}else if(HttpPost.METHOD_NAME.equals(method)){
			int resumableChunkNumber = getResumableChunkNumber(request);

			ResumableInfo info = getResumableInfo(request);

			RandomAccessFile raf = new RandomAccessFile(info.resumableFilePath, "rw");

			// Seek to position
			raf.seek((resumableChunkNumber - 1) * (long) info.resumableChunkSize);

			// Save to file
			InputStream is = request.getInputStream();
			long readed = 0;
			long content_length = request.getContentLength();
			byte[] bytes = new byte[1024 * 100];
			while (readed < content_length) {
				int r = is.read(bytes);
				if (r < 0) {
					break;
				}
				raf.write(bytes, 0, r);
				readed += r;
			}
			raf.close();

			// Mark as uploaded.
			info.uploadedChunks.add(new ResumableInfo.ResumableChunkNumber(resumableChunkNumber));
			if (info.checkIfUploadFinished()) { // Check if all chunks uploaded, and change filename
				ResumableInfoStorage.getInstance().remove(info);
				response.getWriter().print("All finished.");
			} else {
				response.getWriter().print("Upload");
			}
		}
	}
	
	private int getResumableChunkNumber(HttpServletRequest request) {
		return UploadUtils.toInt(request.getParameter("resumableChunkNumber"), -1);
	}

	private ResumableInfo getResumableInfo(HttpServletRequest request)throws ServletException, UnsupportedEncodingException {
		String base_dir = adminConfig.getUploadDir();
		int resumableChunkSize = UploadUtils.toInt(request.getParameter("resumableChunkSize"), -1);
		long resumableTotalSize = UploadUtils.toLong(request.getParameter("resumableTotalSize"), -1);
		String resumableIdentifier = request.getParameter("resumableIdentifier");
		String resumableFilename = request.getParameter("resumableFilename");
		// String(request.getParameter("resumableFilename").getBytes("ISO8859-1"),"UTF-8");
		String resumableRelativePath = request.getParameter("resumableRelativePath");
		// Here we add a ".temp" to every upload file to indicate NON-FINISHED
		new File(base_dir).mkdir();
		String resumableFilePath = new File(base_dir, resumableFilename).getAbsolutePath() + ".temp";

		ResumableInfoStorage storage = ResumableInfoStorage.getInstance();

		ResumableInfo info = storage.get(resumableChunkSize, resumableTotalSize, resumableIdentifier, resumableFilename,
				resumableRelativePath, resumableFilePath);
		if (!info.vaild()) {
			storage.remove(info);
			throw new ServletException("Invalid request params.");
		}
		return info;
	}
	
}
