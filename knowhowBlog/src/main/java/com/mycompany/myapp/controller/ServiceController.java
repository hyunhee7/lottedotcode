package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
	@RequestMapping("/service/main.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/main");
		return mView;
	}
	@RequestMapping("/service/projectTimeline.do")
	public ModelAndView projectTimeline(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectTimeline");
		return mView;
	}
	@RequestMapping("/service/projectDetail.do")
	public ModelAndView projectDetail(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectDetail");
		return mView;
	}
	@RequestMapping("/service/projectList.do")
	public ModelAndView projectList(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectList");
		return mView;
	}	
	@RequestMapping("/service/knowhowList.do")
	public ModelAndView knowhowList(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/knowhowList");
		return mView;
	}	
	@RequestMapping("/service/knowhowDetail.do")
	public ModelAndView knowhowDetail(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/knowhowDetail");
		return mView;
	}		
}
