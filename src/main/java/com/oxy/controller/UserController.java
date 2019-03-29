package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.UserService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.user.AddUserVO;
import com.oxy.vo.user.PageUserVO;
import com.oxy.vo.user.UpdateUserVO;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/page",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
	public JsonResult pageResult(@Validated @RequestBody PageUserVO vo) {
		return new JsonResult(0,userService.page(vo),"成功");
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
	public JsonResult add(@Validated @RequestBody AddUserVO vo) {
		userService.insert(vo);
		return new JsonResult(0,"成功");
	}
	
	@RequestMapping(value="/",method = RequestMethod.PUT,produces={
	"application/json;charset=utf-8"})
	public JsonResult update(@Validated @RequestBody UpdateUserVO vo) {
		userService.update(vo);
		System.out.println(vo.getName());
		return new JsonResult(0,"成功");
	}
}
