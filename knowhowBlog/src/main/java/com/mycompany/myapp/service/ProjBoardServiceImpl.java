package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dto.ProjBoardDto;
/* 프로젝트 보드 Service */
@Service
public class ProjBoardServiceImpl implements ProjBoardService {

	@Autowired
	private ProjBoardDao projboardDao;
	
	/* 프로젝트 등록 */
	@Override
	public void insert(ProjBoardDto dto) {
		projboardDao.insert(dto);
	}

	/* 프로젝트 리스트 */
	@Override
	public List<ProjBoardDto> list() {
		List<ProjBoardDto> list=projboardDao.getList();
		return list;
	}	
	
	/* 최근 프로젝트 리스트 */
	@Override
	public List<ProjBoardDto> recentList() {
		List<ProjBoardDto> list=projboardDao.getRecentList();
		return list;
	}	
	
	/* 프로젝트 상세보기 */
	@Override
	public ProjBoardDto detail(int proj_num) {
		ProjBoardDto dto = projboardDao.getDetail(proj_num);
		return dto;
	}
	
	/* 프로젝트 수정하기 */
	@Override
	public void update(ProjBoardDto dto) {		
		projboardDao.update(dto);
	}
	
	/* 프로젝트 삭제 */
	@Override
	public void delete(int proj_num) {
		projboardDao.delete(proj_num);
	}
}
