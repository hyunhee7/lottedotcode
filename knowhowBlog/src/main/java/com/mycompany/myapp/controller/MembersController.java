package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.MembersDto;
import com.mycompany.myapp.service.MembersService;

@Controller
public class MembersController {
	
	@Autowired
	private MembersService membersService;
	
	@RequestMapping("/members/loginform.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("members/loginform");
		return mView;
	}
	
	@RequestMapping("/members/signupform.do")
	public ModelAndView signin(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("members/signupform");
		return mView;
	}		
	
	//회원가입 요청 처리
	@RequestMapping("/members/signup")
	public ModelAndView signup(@ModelAttribute MembersDto dto,
			HttpServletRequest request) {
		ModelAndView mView = membersService.signup(dto, request);
		
		mView.setViewName("members/alert");
		return mView;
	}
}
