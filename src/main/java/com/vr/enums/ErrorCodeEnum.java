package com.vr.enums;

/**
 * Description: 错误状态码
 * All Rights Reserved.
 * @version 1.0  2016年12月10日 下午12:07:51  by 代鹏（daipeng.456@gmail.com）创建
 */
public enum ErrorCodeEnum {
	
	ERROR_10000("10000", "参数不合法!"),
	ERROR_10001("10001", "视频资源记录不存在!"),
	ERROR_10002("10002", "编辑视频失败，请重试!");
	
	private String code;
	private String msg;
	
	private ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
