package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.interfaces.Claim;
import com.example.bean.Role;
import com.example.bean.Token;
import com.example.bean.User;
import com.example.service.UserService;
import com.example.utils.JwtToken;
import com.example.utils.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController(value="userController")
@Api(value = "用户模块操作", description = "用户模块操作")
public class userController {

	@Autowired
	private UserService userService;
	
		@RequestMapping(value = "authority/login", method = RequestMethod.GET)
	    @ApiOperation(value = "登录", notes = "登录接口的简介")
	    public String login(String account, String password) throws Exception {
			String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			String ph = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
			User user = new User();
			if(account.matches(ph)) {
				user.setEmail(account);
			}else if(account.matches(ph)) {
				user.setTelephone(account);
			}else {
				user.setUsername(account);
			}
			user.setPassword(password);
			User testUser = userService.userLogin(user);
			if(testUser==null) {
				return "fail";
			}
			String token = JwtToken.createToken();
			System.out.println(token);
			
			Map<String, Claim> claim = JwtToken.verifyToken(token);
			System.err.println(claim.toString());
			
//			String tokenExpire = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWxlcGhvbmUiOiIxODMxNjYzMjAwOCIsIlVBIjoiVUExMjM0NTYiLCJleHAiOjE1NjM1MDc5MzIsImlhdCI6MTU2MzUwNzg3MiwidXNlcm5hbWUiOiIwMDFhZG1pbiJ9.kJDQd5oI22wx_xGBtoq6n_umzvouKYKWQJQVRtwSD6w";
//			Map<String, Claim> claimExpire = JwtToken.verifyToken(tokenExpire);
//			System.err.println(claimExpire.toString());
			Token mytoken = new Token();
			mytoken.setToken(token);
			Result result = new Result(200,"验证成功","success",mytoken);
			
	        return result.toString();
	    }
		
		@RequestMapping(value = "index.do", method = RequestMethod.GET)
	    @ApiOperation(value = "登录", notes = "登录接口的简介")
	    public ModelAndView index() {
//			User user = userService.findByUsername(account);
			
			return new ModelAndView("authorize");
	    }
		
		@RequestMapping (value = "authority/resourceBack", method = RequestMethod.GET)
	    @ApiOperation(value = "resourceBack", notes = "结果返回")
	    public ModelAndView resourceBack(String state, String code) {
			ModelAndView mav = new ModelAndView("index");// 此处指向登陆界面
			mav.getModel().put("state", state);
			mav.getModel().put("code", code);
			return mav; 
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
			role.setRolesname("普通管理员");
			userService.addRole(role);
	    }
}
