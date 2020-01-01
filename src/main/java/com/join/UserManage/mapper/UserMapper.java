package com.join.UserManage.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.join.UserManage.entity.User;

@Repository
public interface UserMapper {
	public User getUserinfo(@Param("id") String id);
}
