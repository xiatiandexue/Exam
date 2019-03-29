package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.oxy.model.User;
import com.oxy.service.UserService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.user.UserLoginVO;
import com.oxy.dto.UserLoginDto;


@RestController
@CrossOrigin
public class LoginController {
	@Resource
    private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
//	public String login(){
//		return "this is Spring boot demo!";
//	}
	public JsonResult login(@RequestBody UserLoginVO userLoginReq) {
		if (Strings.isNullOrEmpty(userLoginReq.getUsercode())) {
			return new JsonResult(-2,"用户名不能为空");
		}
		if (Strings.isNullOrEmpty(userLoginReq.getPassword())) {
			return new JsonResult(-2,"密码不能为空");
		}
		if (Strings.isNullOrEmpty(userLoginReq.getRole())) {
			return new JsonResult(-2,"用户类型不能为空");
		}
		if(userService.login(userLoginReq.getUsercode(),userLoginReq.getPassword(),userLoginReq.getRole()) != null) {
			String name = userService.getUser(userLoginReq.getUsercode()).getName();
			UserLoginDto userLoginResp = new UserLoginDto(userLoginReq.getUsercode(),name, userLoginReq.getRole());
			return new JsonResult(0,userLoginResp,"登录成功");
		} else {
			return new JsonResult(-2,"用户名、密码或用户类型有误，请重新输入");
		}
		
	}

    @RequestMapping(value="/showUser",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
    @ResponseBody
    public User getUser(@RequestBody UserLoginVO userLoginReq){
        
    	return userService.getUser(userLoginReq.getUsercode());
    }
}
