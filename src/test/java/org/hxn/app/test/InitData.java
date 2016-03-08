package org.hxn.app.test;

import org.hxn.app.entity.Resource;
import org.hxn.app.entity.Role;
import org.hxn.app.entity.User;
import org.hxn.app.service.ResourceService;
import org.hxn.app.service.RoleService;
import org.hxn.app.service.UserService;
import org.hxn.app.shiro.kit.ShiroKit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class InitData {

	public static String[] usernames = new String[] { "凌之", "丹梅", "凝易", "梦夏", "如蕾", "孤竹", "丹晴", "尔梅", "友春", "思天", "梦白",
			"醉柔", "问雁", "听莲", "觅烟", "怀白", "雨薇", "海风", "半丹", "念兰", "代蓉", "幼亦", "依绿", "凌冬", "绮真", "盼海", "飞青", "冬香", "映桃",
			"亦真", "慕玉", "听琴", "翠雁", "晓槐", "语文", "念阳", "春芙", "飞凝", "醉竹", "凌菱", "雅荷", "绮春", "山薇", "雅夏", "涵霜", "香柔", "语雪",
			"恨冬", "寒春", "飞莲", "平天", "念萱", "寄海", "沛菱", "雨香", "亦菡", "慕香", "静双", "半香", "凝阳", "问秋", "梦薇", "尔翠", "天凡", "念儿",
			"小海", "碧松", "如天", "语巧", "雁雪", "雪柏", "惜彤", "幼卉", "巧晴", "友天", "幻文", "诗雁", "孤珊", "乐丝", "采秋", "书梦", "语竹", "小翠",
			"冬双", "问烟", "初松", "沛蓝", "寒蓝", "凝柏", "诗真", "香曼", "妙玉", "初枫", "晓山", "香筠", "初梅", "又雪", "采灵", "灵莲", "凝珍", "凡雁",
			"芷蝶", "丹雁", "靖灵", "书柳", "含风", "静香", "盼蕾", "含香", "寄山", "笑雁", "凌海", "诗彤", "尔晴", "易玉", "念波", "涵菱", "易霜", "宛白",
			"傲南", "怀荷", "晓槐", "幻山", "静萍", "丹山", "宛之", "又晴", "元灵", "晓蝶", "如萍", "如丝", "书竹", "幻晴", "雁山", "白桃", "寄霜", "晓槐",
			"醉安", "凡柔", "妙云", "雁柏", "诗珊", "诗瑶", "思香", "梦菡", "夜阳", "若云", "春蝶", "觅香", "巧绿", "孤秋", "小柔", "含萱", "雨松", "平凝",
			"冬烟" };

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	@Test
	public void addAdmin() {
		User user = new User();
		user.setAge(18);
		user.setNickname("Jack");
		user.setUsername("jack");
		user.setPassword(ShiroKit.md5("123", user.getUsername()));
		userService.save(user);

		Role role = new Role();
		role.setName("管理员");
		role.setSn("ADMIN");
		roleService.save(role);

		Resource resource = new Resource();
		resource.setName("欢迎1");
		resource.setUrl("/hello/hello1");
		resourceService.save(resource);

		user = userService.get("username", "jack");
		role = roleService.get("sn", "ADMIN");
		resource = resourceService.get("url", "/hello/hello1");
		user.getRoles().add(role);
		role.getResources().add(resource);
		userService.update(user);
		roleService.update(role);

	}

	@Test
	public void addUser() {
		User user = new User();
		user.setAge(18);
		user.setNickname("Hxn");
		user.setUsername("hxn");
		user.setPassword(ShiroKit.md5("123", user.getUsername()));
		userService.save(user);

		Role role = new Role();
		role.setName("普通用户");
		role.setSn("USER");
		roleService.save(role);

		Resource resource = new Resource();
		resource.setName("欢迎2");
		resource.setUrl("/hello/hello2");
		resourceService.save(resource);

		user = userService.get("username", "hxn");
		role = roleService.get("sn", "USER");
		resource = resourceService.get("url", "/hello/hello2");
		user.getRoles().add(role);
		role.getResources().add(resource);
		userService.update(user);
		roleService.update(role);

	}

}
