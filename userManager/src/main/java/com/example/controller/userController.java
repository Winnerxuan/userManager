package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Role;
import com.example.bean.User;
import com.example.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController(value="userController")
@Api(value = "用户模块操作", description = "用户模块操作")
public class userController {

	@Autowired
	private UserService userService;
	
		@PostMapping("authority/login")
	    @ApiOperation(value = "登录", notes = "登录接口的简介")
	    public void login(String account, String password) {
//			User user = userService.findByUsername(account);
			
	        return;
	    }
		
		@PostMapping("authority/register")
	    @ApiOperation(value = "注册", notes = "注册接口的简介")
	    public void register(String username, String password, String telephone, User user, Role role) {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			String id = telephone + df.format(new Date());
			user.setId("F3DC4DFFECFBC030");
			user.setUsername(username);
			user.setPassword(password);
			user.setTelephone(telephone);
			userService.addUser(user);
			role.setUserid("F3DC4DFFECFBC030");
			role.setRoleid(34223);
			role.setRolesname("普通管理员");
			userService.addRole(role);
	    }
}
