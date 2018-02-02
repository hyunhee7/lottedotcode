package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjTimelineDto;


public interface ProjTimelineService {
	public void insert(ProjTimelineDto dto,HttpServletRequest request);
	ModelAndView list(int num);
}
