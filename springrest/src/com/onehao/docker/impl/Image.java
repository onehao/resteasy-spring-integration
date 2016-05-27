package com.onehao.docker.impl;

import com.onehao.docker.IImage;

public class Image implements IImage{
	
	public String name;
	public String status;
	public String url;
	public double size;
	public String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

}
