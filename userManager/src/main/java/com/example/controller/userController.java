package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.interfaces.Claim;
import com.example.bean.Permission;
import com.example.bean.Permissionlist;
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
	
		@RequestMapping(value = "authority/login", method = RequestMethod.POST)
	    @ApiOperation(value = "登录", notes = "登录接口的简介")
	    public String login(String account, String password) throws Exception {
			String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			String ph = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
			User user = new User();
			if(account.matches(em)) {
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
			String token = JwtToken.createToken(testUser);
			System.err.println(token);
			
			User findUser = userService.findUserById(testUser.getId());
			
//			String tokenExpire = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWxlcGhvbmUiOiIxODMxNjYzMjAwOCIsIlVBIjoiVUExMjM0NTYiLCJleHAiOjE1NjM1MDc5MzIsImlhdCI6MTU2MzUwNzg3MiwidXNlcm5hbWUiOiIwMDFhZG1pbiJ9.kJDQd5oI22wx_xGBtoq6n_umzvouKYKWQJQVRtwSD6w";
//			Map<String, Claim> claimExpire = JwtToken.verifyToken(tokenExpire);
//			System.err.println(claimExpire.toString());
			Token mytoken = new Token();
			mytoken.setToken(token);
			Result result = new Result(200,"验证成功","success",mytoken);
			
	        return result.toString();
	    }
		
		@RequestMapping(value = "index.do", method = RequestMethod.GET)
	    @ApiOperation(value = "入口", notes = "登录接口的简介")
	    public ModelAndView index() {
//			User user = userService.findByUsername(account);
			
			return new ModelAndView("authorize");
	    }

		@RequestMapping(value = "swagger.do", method = RequestMethod.GET)
		@ApiOperation(value = "入口", notes = "登录接口的简介")
		public void swagger() throws Exception {
	//			User user = userService.findByUsername(account);

			//SwaggerChange.generateAsciiDocs();
		}
		
		@RequestMapping(value = "authority/resourceBack", method = RequestMethod.GET)
	    @ApiOperation(value = "拦截认证", notes = "登录接口的简介")
	    public ModelAndView resourceBack(String state, String code) {
//			User user = userService.findByUsername(account);
			ModelAndView maView = new ModelAndView("index");
			maView.getModel().put("state", state);
			maView.getModel().put("code", code);
			System.err.println(code);
			return maView;
	    }
		
		@RequestMapping (value = "authority/getUserSource", method = RequestMethod.GET)
	    @ApiOperation(value = "getUserSource", notes = "获取用户信息")
	    public String getUserSource(String token) throws Exception {
			
			Map<String, Claim> claim;
			try {
				claim = JwtToken.verifyToken(token);
				String userid = claim.get("userid").asString();
				User findUser = userService.findUserById(userid);
				Role findRole = userService.findRoleByuserid(findUser.getId());
				
				//封装userResource
				Map<String, Object> userMap = new LinkedHashMap<>();
				userMap.put("id", findUser.getId());
				userMap.put("name", findUser.getName());
				userMap.put("username", findUser.getUsername());
				userMap.put("avatar", "/avatar2.jpg");
				userMap.put("status", findUser.getStatus() );
				userMap.put("telephone", findUser.getTelephone());
				userMap.put("createTime", findUser.getCreatetime() );
				
				//封装第二层  role
				Map<String, Object> roleMap = new LinkedHashMap<>();
				roleMap.put("rolesCode", findRole.getRolescode());
				roleMap.put("rolesName", findRole.getRolesname());
				roleMap.put("rolesId", findRole.getRoleid());
				
				//封装第三层 permissions
				ArrayList<Map<String, Object>> permissionsMap = new ArrayList<Map<String,Object>>();
				
				//封装第四层 permssionList和actionEntitySet
				Map<String, Object> permissionListMap = new LinkedHashMap<>();
				ArrayList<String> permissionList = new ArrayList<String>();
				permissionList.add("tasksList");
				//actionEntitSet里面应该存action对象的
				ArrayList<String> actionEntitSet = new ArrayList<String>();
				actionEntitSet.add("action");
				permissionListMap.put("permissionList", permissionList);
				permissionListMap.put("actionEntitySet", actionEntitSet);
//				Map<String, Object> actionEntitySet = new LinkedHashMap<>();
//				actionEntitySet.put("actionEntitSet", actionEntitSet);
				
				permissionsMap.add(permissionListMap);
//				permissionsMap.add(actionEntitySet);
				
				roleMap.put("permissions", permissionsMap);
				
				userMap.put("role", roleMap);
				
				Result result = new Result(200,"验证成功","success",userMap);
				return result.toString(); 
			} catch (Exception e) {
				return "登录凭证已过去，请重新登录";
			}
			
	    }
		
		@PostMapping("authority/register")
	    @ApiOperation(value = "注册", notes = "注册接口的简介")
	    public String register(String username, String password, String telephone, String email) {
			
			User user = new User();
			String id = DigestUtils.md5DigestAsHex(telephone.getBytes());
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setTelephone(telephone);
			user.setEmail(email);
			userService.addUser(user);
			
			Role role = new Role();
			String roleid = DigestUtils.md5DigestAsHex(id.getBytes());
			role.setRoleid(roleid);
			role.setUserid(id);
			role.setRolescode(20000);
			role.setRolesname("普通管理员");
			userService.addRole(role);
			
			Permission permission = new Permission();
			String permissionid = DigestUtils.md5DigestAsHex(roleid.getBytes());
			permission.setPermissionid(permissionid);
			permission.setRoleid(roleid);
			
			Permissionlist permissionlist = new Permissionlist();
			
			Result result = new Result(200,"验证成功","success",null);
			return result.toString();
			
			
			
	    }
}
