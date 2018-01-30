package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.ProjTimelineDto;

@Service
public class ProjTimelineServiceImpl implements ProjTimelineService{
	
	@Autowired
	private ProjTimelineDao projTimelineDao;
	
	@Override
	public ModelAndView list(int num) {
		List<ProjTimelineDto> list = projTimelineDao.getList(num);
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}
	
}
