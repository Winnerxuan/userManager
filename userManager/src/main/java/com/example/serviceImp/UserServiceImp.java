package com.example.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Role;
import com.example.bean.User;
import com.example.dao.RoleMapper;
import com.example.dao.UserMapper;
import com.example.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public void addUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public void addRole(Role role) {
		roleMapper.insert(role);
	}

}
