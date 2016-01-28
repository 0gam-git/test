package com.urong.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.urong.dto.User;
import com.urong.service.UserService;

@Controller
public class SecurityController {

/*	@Autowired
	private UserService userService;
*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String root(){
		return "login";
	}

	@RequestMapping(value = "/accessLogin", method = RequestMethod.POST)
	public ModelAndView accessLogin(User user) {
		ModelAndView mav = new ModelAndView();
//		String id = user.getId();
//		String pass = user.getPassword();
//
//		System.out.println("id== " + id);
//		System.out.println("pass== " + pass);
//
////		User userInfo = userService.login(user);
//
//		mav.setViewName("/login");
//		mav.addObject("userInfo", userInfo);

		return mav;
	}
}
