$(function() {
	grid = $('#resource-table').datagrid({	
		url : '/resource/getVideos',
		dataType : 'json',
		pagination : 10,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
		// fit:true,
		// fitColumns:true,
		nowrap : false,
		border : false,
		// singleSelect:true,
		striped : true,
		rownumbers : true,
		columns : [ [ {
			field : 'videoId',
			title : 'ID',
			width : 50,
			checkbox : false
		}, {
			field : 'userName',
			title : '作者',
			width : 150,
			sortable : false
		}, {
			field : 'title',
			title : '标题',
			width : 200,
			sortable : false
		}, {
			field : 'description',
			title : '描述',
			width : 300,
			sortable : false
		}, {
			field : 'status',
			title : '状态',
			width : 50,
			sortable : true
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
			title : '上传时间',
			width : 200,
			sortable : true
		} , {
			field : 'publishTime',
			title : '发布时间',
			width : 200,
			sortable : true
		}] ],
		toolbar : [ {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editVideo
		}, '-', {
			text : '审核',
			iconCls : 'icon-remove',
			handler : auditVideo
		} ]
	});
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#video-window').window({
		closed : true
	});
	form = win.find('form')
});

var grid;
var win;
var form;

function editVideo() {
	var rows = grid.datagrid('getSelections');
	if (rows.length == 1) {
		win.window('open');
		form.form('load', rows[0]);
		url = '/user/findUser?userid=' + rows[0].userId;
	} else if (rows.length == 0) {
		$.messager.alert('提示', '请选择一条修改记录!', 'info');
	} else if (rows.length >= 0) {
		$.messager.alert('提示', '只能选择一条修改记录!', 'info');
	}
}
function saveUser() {
	$('form').form('submit', {
		url : '/user/saveUser',
		onsubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			if (result == true) {
				$.messager.alert('提示信息', '操作成功');
				$("#resource-table").dialog("close");
				$("#resource-table").datagrid("load");
			} else {
				$.messager.alert("提示信息", "操作失败");
			}
		}
	});
}
function auditVideo() {
	var rows = grid.datagrid('getSelections');
	
	if (rows.length >= 1) {
		var ids = '';
		$.each(rows,function(n,value){
			ids += value.userId;
			ids += ',';
		});
		form.form('load', '/user/deleteUser?userid=' + ids);
		$('#resource-table').datagrid('reload');
	} else {
		$.messager.alert('提示', '请选择一条或多条修改记录!', 'info');
	}
}
function findResource() {
	$('#resource-table').datagrid('load', {
		title : $('#video_title').val(),
		categoryId : $('#video_category').val(),
		status : $('#video_status').val()
	});
}
function closeWindow() {
	win.window('close');
}