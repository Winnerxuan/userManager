package com.example.service;

import org.springframework.stereotype.Service;

import com.example.bean.Permission;
import com.example.bean.Role;
import com.example.bean.User;

@Service
public interface UserService {

	void addUser(User user);

	void addRole(Role role);

	User userLogin(User user);

	User findUserById(String userid);

	Role findRoleByuserid(String userId);

	Permission findPermissionByRoleid(String roleId);

}
