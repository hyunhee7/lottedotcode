package com.mycompany.myapp.service;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjBoardDto;

public interface ProjBoardService {
	public void insert(ProjBoardDto dto);
	public ModelAndView list();
}
