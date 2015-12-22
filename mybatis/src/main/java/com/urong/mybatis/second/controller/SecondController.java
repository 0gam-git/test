package com.urong.mybatis.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

	@RequestMapping(value="/a/gg")
	@ResponseBody
	public String testView(){
		
		System.out.println("ResponseBody Test");
		
		return "admin11111";
	}
}
