package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.MembersDto;



public interface MembersService {
	public ModelAndView signup(MembersDto dto, HttpServletRequest request);
	public boolean canUseId(String id);	
	public ModelAndView signin(MembersDto dto, HttpServletRequest request);
	public String getPath(String id);
}
