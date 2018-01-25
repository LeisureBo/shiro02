package com.bo.shiro.web.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Description 业务异常封装
 * @author 王博
 * @version 2018年1月24日　上午12:01:29
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	// 业务类型
	private String bizType;
	// 返回码
	private int retCode;
	// 错误信息
	private String message;

	public BusinessException(String bizType, int retCode, String message) {
		super(message);
		this.bizType = bizType;
		this.retCode = retCode;
		this.message = message;
	}

	public BusinessException(String message) {
		super(message);
		this.bizType = "";
		this.retCode = -1;
		this.message = message;
	}

	public BusinessException(String bizType, String message) {
		super(message);
		this.bizType = bizType;
		this.retCode = -1;
		this.message = message;
	}

	public BusinessException(int retCode, String message) {
		super(message);
		this.bizType = "";
		this.retCode = retCode;
		this.message = message;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
