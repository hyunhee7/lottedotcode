package com.mycompany.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;

public interface KnowhowService {
	public ModelAndView list();
	public ModelAndView Searchlist(String tag_name);	
	public int insert(KnowhowDto dto,HttpServletRequest request);
	public ModelAndView detail(KnowhowDto dtoNum);
	public ModelAndView getFile(KnowhowDto dtoNum);
	public void update(KnowhowDto dto, HttpServletRequest request);	
	public void delete(int kh_num);
	public void cmtInsert(KnowhowCommentDto dto);
	public List<KnowhowDto> recentList();
}
