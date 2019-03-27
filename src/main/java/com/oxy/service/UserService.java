package com.oxy.service;

import java.util.List;
import java.util.Map;

import com.oxy.model.User;


public interface UserService {
	User getUser(String usercode);
	User login(String usercode, String password, String role);
}
