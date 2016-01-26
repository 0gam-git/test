package com.thymeleaf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thymeleaf.model.Login;
import com.thymeleaf.model.Project11;

@Controller
public class ThymeleafTestController {

	@RequestMapping(value = "loginForm.do")
	private String test() {
		return "loginForm";
	}

	@RequestMapping(value = "login.do")
	private ModelAndView login(Login login) {
		ModelAndView mav = new ModelAndView();

		String id = login.getId();
		String password = login.getPassword();

		System.out.println("id == " + id);
		System.out.println("passowrd == " + password);

		mav.addObject("getId", id);
		mav.setViewName("successLogin");

		return mav;
	}

	@RequestMapping(value = "writeProject.do")
	private String writeProject() {

		return "writeProject";
	}

	// @RequestMapping(method = RequestMethod.GET)
	// public @ResponseBody Project get(HttpServletResponse res) {
	// Project p = new Project();
	// p.setProjectName("name");
	// p.setProjectDecription("Decription");
	//
	// return p;
	// }

	Project11 p;

	@RequestMapping(value = "createProject.do", method = RequestMethod.POST)
	private @ResponseBody Project11 createProject(HttpServletRequest req) { // 파라미터
		p = new Project11();

		p.setProjectName(req.getParameter("projectName"));
		p.setProjectDecription(req.getParameter("projectDecription"));

		return p;
	}

	@RequestMapping(value = "createProject1.do", method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestBody final Project11 project) { // 제이슨 맵퍼

		System.out.println(project.getProjectName());
		System.out.println(project.getProjectDecription());

		return "dd";
	}
	
	
	/*
	public static HashMap<String, Object> convertJsonToObject(String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
		};
		HashMap<String, Object> object = objectMapper.readValue(json, typeReference);
		return object;
	}

	// 클라이언트에게 전송할 응답 데이터를 JSON 객체로 변환
	@RequestMapping(value = "createProject1.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> listByFilter(@RequestBody String filterJSON) {
		Map<String, Object> message = new HashMap<String, Object>();
		// message.put(key, value)

		return message;
	}*/

	@RequestMapping(value = "aop.do")
	public String aopTest() {
		System.out.println("aopTest");

		return "aopTest";
	}
}
