package com.join.UserManage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.join.UserManage.entity.User;
import com.join.UserManage.esRepository.EsRepository;
import com.join.UserManage.mapper.UserMapper;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EsRepository esRepository;
	
	public String getUinfo(String id) {
		User user= userMapper.getUserinfo(id);
		return user.getName();
	}
	public User esQueryById(String id) {
		// TODO Auto-generated method stub
		Optional<User> opuser = esRepository.findById(id);
		return opuser.get();
	}

}
