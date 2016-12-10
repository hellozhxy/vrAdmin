$(function() {
	grid = $('#resource-table').datagrid({	
		url : '/resource/getVideos',
		dataType : 'json',
		pagination:true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
		fit:true,
		fitColumns:true,
		nowrap : false,
		border : false,
		singleSelect:true,
		striped : true,
		rownumbers : true,
		columns : [ [ 
		 {
			 field : 'id',
			 title : 'ID'
		 },
		 {
			field : 'userNickName',
			title : '作者',
			width : 100,
			sortable : false
		}, {
			field : 'title',
			title : '标题',
			width : 200,
			sortable : false
		}, {
			field : 'description',
			title : '描述',
			width : 350,
			sortable : false,
			formatter : subStringFormatter
		}, {
			field : 'status',
			title : '状态',
			width : 50,
			sortable : true,
			formatter : statusFormatter
		}, {
			field : 'categoryName',
			title : '分类',
			width : 100,
			sortable : false
		}, {
			field : 'keywords',
			title : '关键字',
			width : 100,
			sortable : false
		}, {
			field : 'path',
			title : '路径',
			width : 300,
			sortable : false
		} , {
			field : 'playTimes',
			title : '播放次数',
			width : 100,
			sortable : true
		} , {
			field : 'createTime',
			title : '创建时间',
			width : 200,
			sortable : true,
			formatter : dateFormatter
		} , {
			field : 'publishTime',
			title : '发布时间',
			width : 200,
			sortable : true,
			formatter : dateFormatter
		}] ]
	});
	
	var p = $('#resource-table').datagrid('getPager'); 
    $(p).pagination({ 
        pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],//可以设置每页记录条数的列表 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
    }); 
});

var grid;
var edit_url;

function showAddVideo(){
	
}

function showEditVideo(){
	var rows = grid.datagrid('getSelections');
	if (rows.length == 1) {
		$('#edit-video-window').dialog('open').dialog('setTitle','编辑视频');  
	    $('#editForm').form('load',rows[0]);
	    //格式化时间格式
	    $('#editForm input[name="createTime"]').attr("value", dateFormatter(rows[0].createTime));
	    $('#editForm input[name="publishTime"]').attr("value", dateFormatter(rows[0].publishTime));
	    //分类
	    $('#categoryNameSelect option').each(function(){
			if ($(this).text() == rows[0].categoryName) {  
                $(this).attr("selected", "selected");
                return
            }  
		});
	    
	    $('#video_status option').each(function(){
			if ($(this).text() == rows[0].status) {  
                $(this).attr("selected", "selected");
                return
            }  
		});
	    /* 不知为何不生效
	    $.post('/resource/videoCategorys',function(result){
	    	if(result != null && result.length > 0){
	    		
	    		$('#editForm input[name="categoryName"]').html("");
	    		var optionHtml = "";
	    		$.each(result, function(i, item){
	    			optionHtml += "<option value=" + item.id + ">" + item.categoryName + "</option>";
	    		});
	    		$('#editForm input[name="categoryName"]').append(optionHtml);
	    		
	    	}else{
	    		alert("获取视频分类失败,请重试!");
	    	}
        },'json');*/
	    edit_url = '/resource/updateVideo?videoId=' + rows[0].id;
	} else if (rows.length == 0) {
		$.messager.alert('提示', '请选择一条修改记录!', 'info');
	} else if (rows.length > 1) {
		$.messager.alert('提示', '只能选择一条修改记录!', 'info');
	}
}

function editVideo(){  
    $('#editForm').form('submit',{  
        url: edit_url, 
        onSubmit: function(){  
            return $(this).form('validate');  
        },  
        success: function(result){  
            var result = eval('('+result+')');  
            if (result.errorMsg){  
                $.messager.show({  
                    title: 'Error',  
                    msg: result.errorMsg  
                });  
            } else {  
                $('#edit-video-window').dialog('close'); // close the dialog  
                $('#resource-table').datagrid('reload'); // reload the user data  
            }  
        }  
    });  
}

function findResource() {
	$('#resource-table').datagrid('load', {
		title : $('#video_title').val(),
		categoryId : $('#video_category').val(),
		status : $('#video_status').val()
	});
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function dateFormatter (value) {
    if (value == null || value == '' || value == undefined) {
		return '';
	}
	var dt = new Date(value);
    return dt.Format("yyyy-MM-dd hh:mm:ss");
}

function subStringFormatter (value) {
	if (value == null || value == '' || value == undefined) {
		return '';
	}
    if (value.length > 30) value = value.toString().substring(0, 10) + "...";
    return value;
}

function statusFormatter(value){
	if(value == "0"){
		return "无效";
	}else if(value == "1"){
		return "有效";
	}
	return "未知";
}

