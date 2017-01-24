package com.jhwan.blog.dto;

import java.util.List;

import com.jhwan.blog.model.UserInfo;

import lombok.Data;

@Data
public class LoginResponse {
	List<UserInfo> userInfoList;
}
