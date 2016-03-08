package org.hxn.app.service.impl;

import org.hxn.app.base.service.impl.BaseServiceImpl;
import org.hxn.app.dao.AreaDao;
import org.hxn.app.entity.Area;
import org.hxn.app.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService{
	
	@Autowired
	private AreaDao areaDao;
	
	public AreaDao getAreaDao() {
		return areaDao;
	}
	
	@Autowired
	public void setBaseDao(AreaDao areaDao) {
		super.setBaseDao(areaDao);
	}
}
