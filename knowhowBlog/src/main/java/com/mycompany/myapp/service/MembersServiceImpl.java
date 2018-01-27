package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;

@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao membersDao;

	@Override
	public ModelAndView signup(MembersDto dto, HttpServletRequest request) {
		System.out.println("들어옴2");
		membersDao.insert(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", dto.getId()+" 회원님! 가입이 완료되었습니다.");
		mView.addObject("url", request.getContextPath());		
		return mView;
	}

}
