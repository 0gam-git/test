package com.urong.mybatis.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class restfulTestController {

	
	@RequestMapping(value="/members/{memberId}")
	public ModelAndView memberDetail(@PathVariable(value="memberId") String id){
		ModelAndView model = new ModelAndView();
		
		//모델 인포 찾는 로직
		
//		model.addObject(attributeName, attributeValue);
		
		return model;
	}
}
