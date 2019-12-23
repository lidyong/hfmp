package com.join.UserManage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.join.UserManage.entity.User;
import com.join.UserManage.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public String getUinfo(String id) {
		User user= userMapper.getUserinfo(id);
		return user.getName();
	}

}
