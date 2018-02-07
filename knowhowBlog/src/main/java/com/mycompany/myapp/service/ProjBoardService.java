package com.mycompany.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjBoardDto;

public interface ProjBoardService {
	public void insert(ProjBoardDto dto,HttpServletRequest request);
	public ModelAndView list();
	public List<ProjBoardDto> recentList();
	public ModelAndView detail(int num);
	public void update(ProjBoardDto dto, HttpServletRequest request);
	public void delete(int proj_num);
}
