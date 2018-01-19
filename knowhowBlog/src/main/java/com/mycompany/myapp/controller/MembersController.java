package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MembersController {
	
	@RequestMapping("/login.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("members/login");
		return mView;
	}
	
	@RequestMapping("/signup.do")
	public ModelAndView signin(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("members/signup");
		return mView;
	}		
}
