package com.onehao.entity;

public class Result {
	String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String status;
	public Result(String message, String status){
		this.message = message;
		this.status = status;
	}
}
