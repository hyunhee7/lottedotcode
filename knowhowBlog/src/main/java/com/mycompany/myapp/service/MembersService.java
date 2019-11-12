package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.MembersDto;
/* 회원 Service */
public interface MembersService {
	public MembersDto signup(MembersDto dto);
	public boolean canUseId(String id);	
	public boolean signin(MembersDto dto);
	public String getPath(String id);
}
