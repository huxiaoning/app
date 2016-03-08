package org.hxn.app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hxn.app.shiro.kit.ShiroKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,ModelMap model){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String emsg = null;
		try {
			subject.login(token);
			System.out.println("登录成功");
		} catch (AuthenticationException e) {
			System.out.println("登录失败");
			emsg = e.getMessage();
		}
		if(ShiroKit.isEmpty(emsg)) {
			return "redirect:/admin/user/list";
		} else {
			model.addAttribute("emsg", emsg);
			return "/login";
		}
	}
}
