package com.onehao.customer.impl;

import com.onehao.customer.CustomerBo;

public class CustomerBoImpl implements CustomerBo {

	public String getMsg(String username) {

		return String.format("Hello %s",username);
		
	}

}