package org.hxn.app.base.controller;

import javax.servlet.ServletContext;

import org.hxn.app.service.AddressService;
import org.hxn.app.service.AreaService;
import org.hxn.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

public abstract class BaseController implements ServletContextAware {

	protected ServletContext servletContext;

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Autowired
	protected UserService userService;
	@Autowired
	protected AddressService addressService;
	@Autowired
	protected AreaService areaService;

}