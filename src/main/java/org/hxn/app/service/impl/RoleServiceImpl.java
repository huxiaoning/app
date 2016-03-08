package org.hxn.app.service.impl;

import org.hxn.app.base.service.impl.BaseServiceImpl;
import org.hxn.app.dao.RoleDao;
import org.hxn.app.entity.Role;
import org.hxn.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}
}
