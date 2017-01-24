package com.jhwan.blog.service;

import com.jhwan.blog.dto.LoginRequst;
import com.jhwan.blog.dto.LoginResponse;

public interface LoginService {
	LoginResponse getUserInfo(LoginRequst vo);
}
