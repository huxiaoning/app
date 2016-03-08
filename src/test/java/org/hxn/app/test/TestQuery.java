package org.hxn.app.test;

import java.util.ArrayList;
import java.util.List;

import org.hxn.app.entity.User;
import org.hxn.app.service.UserService;
import org.hxn.app.util.Condition;
import org.hxn.app.util.Operator;
import org.hxn.app.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class TestQuery {
	@Autowired
	private UserService userService;

	@Test
	public void get() {
		List<Condition> conditions = new ArrayList<Condition>();
		conditions.add(new Condition("username", Operator.LIKE, "%白%"));

		List<String> orders = new ArrayList<String>();

		orders.add("address.createTime:desc");

		List<User> users = userService.getByCriteria(conditions, new Page(2, 3), orders);
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println(users.size());

		Integer size = userService.getTotalCountByCriteria(conditions);
		System.out.println(size);
	}

	@Test
	public void testdel() {
		userService.delete("username", "%刘德华%");
	}
}
