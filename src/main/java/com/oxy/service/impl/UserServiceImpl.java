package com.oxy.service.impl;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxy.dao.UserMapper;
import com.oxy.dao.ext.ExtUserMapper;
import com.oxy.dto.PageUserDTO;
import com.oxy.dto.PageUserDTO.PageUserDTOBuilder;
import com.oxy.model.User;
import com.oxy.model.UserExample;
import com.oxy.model.UserExample.Criteria;
import com.oxy.service.UserService;
import com.oxy.utils.ServiceException;
import com.oxy.vo.user.AddUserVO;
import com.oxy.vo.user.PageUserVO;
import com.oxy.vo.user.UpdateUserVO;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Resource
	private ExtUserMapper extUserMapper;
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
	
	@Override
	public PageInfo<PageUserDTO> page(PageUserVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		PageUserDTO dto = PageUserDTO.builder().name(vo.getName()).role(vo.getRole()).build();
		PageInfo<PageUserDTO> pageInfo = new PageInfo<>(extUserMapper.listPage(dto));
		return pageInfo;
	}
	
	public void insert(AddUserVO vo) {

		if (getUser(vo.getUsercode()) != null) {
			throw new ServiceException(-2,"账号已存在");
		}
		validatePassword(vo.getPassword());//密码合法性校验
		User user = vo.toUser();
		userMapper.insert(user);
		
	}
	
	@Override
	public void update(UpdateUserVO vo) {
		User user = getUser(vo.getUsercode());
		if(user==null){
			throw new ServiceException(-2,"当前无此用户信息，请刷新页面");
		}
		User sysUser = vo.toUser();
		if (sysUser == null) {
			return ;
		}
		userMapper.updateByPrimaryKeySelective(sysUser);
	}
	
	@Override
	public void delete(String usercode) {
		
		UserExample example = new UserExample();
		example.createCriteria().andUsercodeEqualTo(usercode);
		userMapper.deleteByExample(example);
	}
	
	
	/**
	 * 密码合法性校验
	 * @param password
	 */
	private void validatePassword(String password){
		String rex = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$";
		if(password != null){
			if(password.length() < 8 ||password.length() > 16){
				throw new ServiceException(-2,"密码长度必须在8~16位");
			}
			if(!password.matches(rex)){
				throw new ServiceException(-2,"密码必须是包含英文大小字母和数字的组合");
			}
		}

	}
	
}
