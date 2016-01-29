package com.urong.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "Spring Security Login Form");
		mav.addObject("message", "DataSource Test");

		mav.setViewName("hello");
		return mav;

	}

	//하나의 컨트롤러로 valid 와 logout을 한번에 한다.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView mav = new ModelAndView();
		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			mav.addObject("msg", "You've been logged out successfully.");
		}
		mav.setViewName("login");

		return mav;
	}
}
