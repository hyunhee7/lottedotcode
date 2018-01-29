package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dto.ProjBoardDto;

@Service
public class ProjBoardServiceImpl implements ProjBoardService {

	@Autowired
	private ProjBoardDao projboardDao;
	
	@Override
	public void insert(ProjBoardDto dto) {
		projboardDao.insert(dto);
	}

	@Override
	public ModelAndView list() {
		List<ProjBoardDto> list=projboardDao.getList();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}	

}
