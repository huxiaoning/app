package org.hxn.app.service.impl;

import org.hxn.app.base.service.impl.BaseServiceImpl;
import org.hxn.app.dao.UserDao;
import org.hxn.app.entity.User;
import org.hxn.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}
}
