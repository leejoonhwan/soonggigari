package com.jhwan.blog.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5962982010605916492L;
	/**
	 * 
	 */
	private String userId;
	private String userPassword;
}
