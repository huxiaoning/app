package org.hxn.app.service.impl;

import org.hxn.app.base.service.impl.BaseServiceImpl;
import org.hxn.app.dao.ResourceDao;
import org.hxn.app.entity.Resource;
import org.hxn.app.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	public void setBaseDao(ResourceDao resourceDao) {
		super.setBaseDao(resourceDao);
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}
}
