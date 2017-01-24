package com.jhwan.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jhwan.blog.dto.LoginRequst;
import com.jhwan.blog.dto.LoginResponse;
import com.jhwan.blog.mapper.SoongMapper;
import com.jhwan.blog.model.UserInfo;

@Component("userInfo")
public class LoginServiceImpl implements LoginService{
	@Autowired
	SoongMapper soongMapper;
	static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	@Override
	public LoginResponse getUserInfo(LoginRequst vo) {
		
		LoginResponse loginResponse = new LoginResponse();
		List<UserInfo> list = new ArrayList<>();
		list = soongMapper.getUserInfo(vo);
		loginResponse.setUserInfoList(list);
		logger.info(loginResponse.getUserInfoList().size());
		return loginResponse;
	}

}
