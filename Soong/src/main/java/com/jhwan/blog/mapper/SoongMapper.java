package com.jhwan.blog.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.jhwan.blog.dto.LoginRequst;
import com.jhwan.blog.model.UserInfo;

@Mapper
public interface SoongMapper {
	List<UserInfo> getUserInfo(LoginRequst loginRequst);
}
