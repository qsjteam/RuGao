package com.qsj.controller;

import javax.servlet.http.HttpSession;

import com.qsj.pojo.User;

public class BaseController {
	public Integer getUid(HttpSession session){
		Integer id = null;
		User user = (User)session.getAttribute("user");
		if(user!=null){
			id = user.getId();
		}
		return id;
	}
}
