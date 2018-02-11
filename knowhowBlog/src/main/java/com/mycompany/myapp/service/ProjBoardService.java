package com.mycompany.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjBoardDto;
/* 프로젝트 보드 Service */
public interface ProjBoardService {	
	public void insert(ProjBoardDto dto,HttpServletRequest request);		/* 프로젝트 등록 */
	public ModelAndView list();												/* 프로젝트 리스트 */
	public List<ProjBoardDto> recentList();									/* 최근 프로젝트 리스트 */
	public ModelAndView detail(int num);									/* 프로젝트 상세보기 */
	public void update(ProjBoardDto dto, HttpServletRequest request);		/* 프로젝트 수정 */
	public void delete(int proj_num);										/* 프로젝트 삭제 */
}
