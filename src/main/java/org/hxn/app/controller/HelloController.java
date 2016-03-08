package org.hxn.app.controller;

import org.hxn.app.base.controller.InitBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController extends InitBaseController {

	@RequestMapping("/hello1")
	public String hello1() {
		return "hello";
	}

	@RequestMapping("/hello2")
	public String hello2() {
		return "hello";
	}
}
