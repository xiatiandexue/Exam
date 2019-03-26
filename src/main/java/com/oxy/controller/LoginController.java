package com.oxy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class LoginController {
	
	@RequestMapping(value="/login",method = RequestMethod.GET,produces={
	"application/json;charset=utf-8"})
	public String login(){
		return "this is Spring boot demo!";
	}
}
