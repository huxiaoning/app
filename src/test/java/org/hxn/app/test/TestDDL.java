package org.hxn.app.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class TestDDL {
	@Test
	public void testDDL() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LocalSessionFactoryBean lsf = (LocalSessionFactoryBean) ac.getBean("&sessionFactory");
		Configuration cfg = lsf.getConfiguration();
		SchemaExport se = new SchemaExport(cfg);
		// 第一个参:是否打印 DDL 到控制台
		// 第二个参:是否 DDL 提交到数据库
		se.create(true, true);
	}
}
