$(function(){
	grid = $('#user-table').datagrid({
		url:'/user/getUsers',
		dataType:'json',
//		title:'用户信息',
		pagination:10,
		pageSize:10,
		pageList:[ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
		fit:true,
		fitColumns:true,
		nowrap : false,
		border : false,
//		width:auto,
//		height:auto,
//		singleSelect:true,
//		striped:true,
		rownumbers:true,
		columns:[[
		          {field:'userName',title:'姓名',width:100,sortable:true},
//		          {field:'mobile',title:'电话',width:100,sortable:true},
//		          {field:'email',title:'邮箱',width:100,sortable:true},
//		          {field:'status',title:'状态',width:100,sortable:true},
//		          {field:'registerDate',title:'注册时间',width:100,sortable:true},
//		          {field:'lastLoginDate',title:'登录时间',width:100,sortable:true},
		          {field:'loginIp',title:'登录IP',width:100,sortable:true}]],
		toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:newUser
		},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:editUser
		},'-',{
			text:'删除',
			iconCls:'icon-remove'
		}]
	});
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#user-window').window({
		closed:true
	});
	form = win.find('form');
});

function fixWidth(percent){
//	return document.body.clientWidth * percent;
	return $('#user-table').css("width") * percent;
}

var grid;
var win;
var form;

function newUser(){
	win.window('open');
	form.form('clear');
	form.url = '/user/addUser';
}
function editUser(){
	var row = grid.datagrid('getSelected');
	if (row){
		win.window('open');
		form.form('load', '/user/getUser/'+row.id);
		form.url = '/user/update/'+row.id;
	} else {
		$.messager.show({
			title:'警告', 
			msg:'请先选择用户资料。'
		});
	}
}
function saveUser(){
	form.form('submit', {
		url:form.url,
		success:function(data){
			eval('data='+data);
			if (data.success){
				grid.datagrid('reload');
				win.window('close');
			} else {
				$.messager.alert('错误',data.msg,'error');
			}
		}
	});
}
function closeWindow(){
	win.window('close');
}