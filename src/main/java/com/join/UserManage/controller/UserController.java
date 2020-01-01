package com.join.UserManage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.join.UserManage.entity.User;
import com.join.UserManage.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * first
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	public String getUserInfo(HttpServletRequest request,String id) {
		return userService.getUinfo(id);
	}
	
	/**
	 * @param request
	 * @param id  elasticsearch
	 * @return
	 */
	@RequestMapping("/esQueryById")
	public String esQueryById(HttpServletRequest request,String id) {
		User user = userService.esQueryById(id);
		System.out.println(user.getName());
		return user.getName();
	}
}
