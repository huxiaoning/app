package org.hxn.app.service.impl;

import org.hxn.app.base.service.impl.BaseServiceImpl;
import org.hxn.app.dao.AddressDao;
import org.hxn.app.entity.Address;
import org.hxn.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService{
	
	@Autowired
	private AddressDao addressDao;
	
	public AddressDao getAddressDao() {
		return addressDao;
	}
	
	@Autowired
	public void setBaseDao(AddressDao addressDao) {
		super.setBaseDao(addressDao);
	}
}
