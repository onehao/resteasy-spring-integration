package com.onehao.health.impl;

import com.onehao.health.IHealth;

public class Health implements IHealth{
	String message = "up and runnings";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	String status = "OK";
	
	public Health(){}
	public Health(String message, String status){
		this.message = message;
		this.status = status;
	}
}