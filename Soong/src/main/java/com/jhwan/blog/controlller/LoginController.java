package com.jhwan.blog.controlller;


import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jhwan.blog.dto.LoginRequst;
import com.jhwan.blog.service.LoginService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@RestController
public class LoginController {
	
	static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	
	/**
	 * 로그인
	 *
	 * @param LoginRequst
	 */
	@RequestMapping(value = "userInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Object getMirizum(@RequestBody LoginRequst loginRequest, HttpServletResponse response) {
		logger.info(":::: 숭기가리 로그인 진입 :::: ");
		logger.info(":::: user_id - "+loginRequest.getUserId());
		logger.info(":::: user_pw - "+loginRequest.getUserPw());
		
		
		return loginService.getUserInfo(loginRequest); 
	}

}
