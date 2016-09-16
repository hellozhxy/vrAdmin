$(function(){
	grid = $('#user-table').datagrid({
		url:'/user/getUsers',
		dataType:'json',
		pagination:10,
		pageSize:10,
		pageList:[ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
//		fit:true,
//		fitColumns:true,
		nowrap : false,
		border : false,
//		singleSelect:true,
		striped:true,
		rownumbers:true,
		columns:[[
		          {field:'id',checkbox:true},
		          {field:'userName',title:'姓名',width:100,sortable:true},
		          {field:'mobile',title:'电话',width:100,sortable:true},
		          {field:'email',title:'邮箱',width:100,sortable:true},
		          {field:'status',title:'状态',width:100,sortable:true},
		          {field:'registerDate',title:'注册时间',width:100,sortable:true},
		          {field:'lastLoginDate',title:'登录时间',width:100,sortable:true},
		          {field:'loginIp',title:'登录IP',width:100,sortable:true}]],
		toolbar:[{
			text:'修改',
			iconCls:'icon-edit',
			handler: function(){
				editUser();
			}
		},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler: function(){
				delUser();
			}
		}]
	});
	$('#btn-save,#btn-cancel').linkbutton();
	win = $('#user-window').window({
		closed:true
	});
});


var grid;
var win;
var form;

function editUser(){
	var rows = grid.datagrid('getSelections');
	if (rows.length == 1){
		win.window('open');
		form.form('load', '/user/getUser/'+row.id);
		form.url = '/user/addUser/'+row.id;
	} else if(rows.length == 0){
		$.messager.alert('提示','请选择一条修改记录!','info');
	} else if(rows.length >= 0){
		$.messager.alert('提示','只能选择一条修改记录!','info');
	}
}
function delUser(){
	var rows = grid.datagrid('getSelections');
	if (rows.length >= 1){
		win.window('open');
		form.form('load', '/user/getUser/'+row.id);
		form.url = '/user/deleteUser/'+row.id;
	} else {
		$.messager.alert('提示','请选择一条或多条修改记录!','info');
	}
}
function findUser(){
	$('#user-table').datagrid('load', {
		name: $('#searchForm').val()
	});
}
function closeWindow(){
	win.window('close');
}