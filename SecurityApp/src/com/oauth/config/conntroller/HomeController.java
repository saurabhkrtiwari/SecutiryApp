package com.oauth.config.conntroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/userPage")
	public String userPage()
	{
		return "userPage";
	}
}
