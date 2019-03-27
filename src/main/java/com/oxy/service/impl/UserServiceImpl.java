package com.oxy.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oxy.dao.UserMapper;
import com.oxy.model.User;
import com.oxy.model.UserExample;
import com.oxy.model.UserExample.Criteria;
import com.oxy.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUser(String usercode) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public User login(String usercode, String password, String role) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		criteria.andPasswordEqualTo(password);
		criteria.andRoleEqualTo(role);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			User user = list.get(0);
			return user;
		} else {
//			throw new ServiceOperationException("用户名或密码有误，请重新输入");
			User user = null;
			return user;
		}
	}
	
	
}
