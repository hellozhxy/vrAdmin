package com.vr.test.base;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vr.utils.ToolsUtil;
import com.vr.web.dao.VideoCategoryMapper;
import com.vr.web.model.VideoCategory;

public class DaoTest extends BaseTest {
	
	@Autowired
	private VideoCategoryMapper videoCategoryMapper;
	
	@Before
	public void beanIsNull(){
		Assert.assertNotNull(videoCategoryMapper);
	}
	
	@Test
	public void test_findVideoCategoryByParams(){
		List<VideoCategory> categorys = videoCategoryMapper.findVideoCategoryByParams(ToolsUtil.builderMapParams("status", 1));
		Assert.assertTrue(categorys.size() > 0);
	}
	
}
