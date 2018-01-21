package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
	@RequestMapping("/main.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/main");
		return mView;
	}
	@RequestMapping("/projectList.do")
	public ModelAndView projectList(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectList");
		return mView;
	}
	@RequestMapping("/projectDetail.do")
	public ModelAndView projectDetail(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectDetail");
		return mView;
	}	
}
