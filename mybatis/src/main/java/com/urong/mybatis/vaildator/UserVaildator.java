package com.urong.mybatis.vaildator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.urong.mybatis.model.Login;

public class UserVaildator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		
		//errorCode ?
		
		if(login.getId().equals("") || login.getId() == null){
			errors.rejectValue("id", "아이디를 입력해주세요.");
		}else if(login.getPassword().equals("") || login.getPassword() == null){
			errors.rejectValue("password", "비밀번호를 입력해주세요.");
		}else if(login.getPassword().length() < 7){
			errors.rejectValue("password", "비밀번호는 8자리 이상으로 설정해주세요.");
		}
		
	}
}
