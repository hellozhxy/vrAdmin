<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/icon.css">
	<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/resumable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/resource.js"></script>
</head>


<body class="easyui-layout" data-options="border:false">
	<div data-options="region:'north',border:false" style="height: 35px; overflow: hidden;background-color: #fff">
		<form id="videoSearchForm">
			<table>
				<tr>
					<th>标题:</th>
					<td><input id="video_title" name="title" placeholder="请输入视频标题"/></td>
					
					<th>分类:</th>
					<td>
					<select id="video_category" name="category">
						<option value="" selected>请选择</option>
						<c:forEach var="item" items="${videoCategorys}">
							<option value="${item.id}">${item.categoryName}</option>
						</c:forEach>
					</select>
					</td>
					
					<th>状态:</th>
					<td>
					<select id="video_status" name="status">
					  <option value="" selected>请选择</option>
					  <option value ="1">有效</option>
					  <option value="0">无效</option>
					</select>
					</td>
					
					<td><a href="javascript:findResource();" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div data-options="region:'center',border:true" >
		<table id="resource-table" class="easyui-datagrid" toolbar="#toolbar" data-options="border:false"></table>
	</div>
	
	<div id="toolbar">  
	    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="showAddVideo()">新增</a>  
	    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="showEditVideo()">编辑</a>  
	</div> 
	
	<div id="edit-video-window" class="easyui-dialog" closed="true" buttons="#edit-buttons" title="编辑窗口" style="width:800px;height:550px;">
		<div style="padding:20px 20px 40px 80px;">
			<form id='editForm' method="post">
				<table width="100%" cellpadding="0" cellspacing="0" style="table-layout:fixed">
					<tr style="visibility:hidden;">
						<td>ID：</td>
						<td><input name="id"></input></td>
					</tr>
					<tr>
						<td width="10">作者：</td>
						<td><input name="userNickName" disabled="true"　readOnly="true"></input></td>
					</tr>
					<tr>
						<td>标题：</td>
						<td><input name="title"></input></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td>
							<textarea rows="15" cols="50" name="description"></textarea>
						</td>
					</tr>
					<tr>
						<td>状态：</td>
						<td>
							<select id="video_status" name="status">
							  <option value ="1">有效</option>
							  <option value="0">无效</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>分类：</td>
						<td>
							<select id="categoryNameSelect" name="categoryName">
								<c:forEach var="item" items="${videoCategorys}">
									<option value="${item.id}">${item.categoryName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>关键字：</td>
						<td><input name="keywords"></input></td>
					</tr>
					<tr>
						<td>路径：</td>
						<td><input id="upload_path" name="path"></input></td>
						<td>
							<div id="frame">
						      <div class="resumable-error">
						        Your browser, unfortunately, is not supported by Resumable.js. The library requires support for <a href="http://www.w3.org/TR/FileAPI/">the HTML5 File API</a> along with <a href="http://www.w3.org/TR/FileAPI/#normalization-of-params">file slicing</a>.
						      </div>
						      <div class="resumable-drop" ondragenter="jQuery(this).addClass('resumable-dragover');" ondragend="jQuery(this).removeClass('resumable-dragover');" ondrop="jQuery(this).removeClass('resumable-dragover');">
						        Drop video files here to upload or <a class="resumable-browse"><u>select from your computer</u></a>
						      </div>
						      <div class="resumable-progress">
						        <table>
						          <tr>
						            <td width="100%"><div class="progress-container"><div class="progress-bar"></div></div></td>
						            <td class="progress-text" nowrap="nowrap"></td>
						            <td class="progress-pause" nowrap="nowrap">
						              <a href="#" onclick="r.upload(); return(false);" class="progress-resume-link"><img src="${pageContext.request.contextPath}/images/resume.png" title="Resume upload" /></a>
						              <a href="#" onclick="r.pause(); return(false);" class="progress-pause-link"><img src="${pageContext.request.contextPath}/images/pause.png" title="Pause upload" /></a>
						            </td>
						          </tr>
						        </table>
						      </div>
						      
						      <ul class="resumable-list"></ul>
						    </div>
						</td>
					</tr>
					<tr>
						<td>播放次数：</td>
						<td><input name="playTimes"></input></td>
					</tr>
					<tr>
						<td>创建时间：</td>
						<td><input name="createTime" disabled="true"　readOnly="true"></input></td>
					</tr>
					<tr>
						<td>发布时间：</td>
						<td><input name="publishTime"></input></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="edit-buttons" style="text-align:center;padding:5px;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editVideo()" icon="icon-save">确认</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#edit-video-window').dialog('close')" icon="icon-cancel">取消</a>
		</div>
	</div>
	
</body>
<script type="text/javascript">
$(function(){
	function contains(arr, obj) {  
	    var i = arr.length;  
	    while (i--) {  
	        if (arr[i] === obj) {  
	            return true;  
	        }  
	    }  
	    return false;  
	}
		
	function fileSuffix(fileName){
		if(fileName.lastIndexOf(".") != -1){
			return fileName.substring(fileName.lastIndexOf(".")+1);
		}
		return null;
	}

	var r = new Resumable({
	    target:'/resource/upload',
	    chunkSize:1*1024*1024,
	    simultaneousUploads:4,
	    testChunks: false,
	    throttleProgressCallbacks:1,
	    method: "octet"
	  });
	// Resumable.js isn't supported, fall back on a different method
	if(!r.support) {
	  $('.resumable-error').show();
	} else {
	  // Show a place for dropping/selecting files
	  $('.resumable-drop').show();
	  r.assignDrop($('.resumable-drop')[0]);
	  r.assignBrowse($('.resumable-browse')[0]);

	  // Handle file add event
	  r.on('fileAdded', function(file){
		  var validFileSuffix = new Array("avi","rmvb","rm","asf","divx","mpg","mpeg","mpe","wmv","mp4","mkv","vob");
	      if(!contains(validFileSuffix, fileSuffix(file.fileName))){
	    	  alert("上传文件不合法!");
	    	  return 
	      }
	      // Show progress pabr
	      $('.resumable-progress, .resumable-list').show();
	      // Show pause, hide resume
	      $('.resumable-progress .progress-resume-link').hide();
	      $('.resumable-progress .progress-pause-link').show();
	      // Add the file to the list
	      $('.resumable-list').append(Math.floor(r.progress()*100) + '%')
	      //$('.resumable-list').append('<li class="resumable-file-'+file.uniqueIdentifier+'">Uploading <span class="resumable-file-name"></span> <span class="resumable-file-progress"></span>');
	      //$('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-name').html(file.fileName);
	      // Actually start the upload
	      r.upload();
	    });
	  r.on('pause', function(){
	      // Show resume, hide pause
	      $('.resumable-progress .progress-resume-link').show();
	      $('.resumable-progress .progress-pause-link').hide();
	    });
	  r.on('complete', function(){
		  alert("文件上传成功!");
	      // Hide pause/resume when the upload has completed
	      $('.resumable-progress .progress-resume-link, .resumable-progress .progress-pause-link').hide();
	      $('.resumable-list').empty();
	    });
	  r.on('fileSuccess', function(file,message){
	      // Reflect that the file upload has completed
	      $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html('(completed)');
	    });
	  r.on('fileError', function(file, message){
	      // Reflect that the file upload has resulted in error
	      $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html('(file could not be uploaded: '+message+')');
	    });
	  r.on('fileProgress', function(file){
	      // Handle progress for both the file and the overall upload
	      $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html(Math.floor(file.progress()*100) + '%');
	      $('.progress-bar').css({width:Math.floor(r.progress()*100) + '%'});
	      //console.log(Math.floor(r.progress()*100) + '%');
	      $('.resumable-list').html(Math.floor(r.progress()*100) + '%');
	    });
	}
});
</script>
</html>
