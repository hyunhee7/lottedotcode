package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.service.ProjBoardService;



@Controller
public class ServiceController {
	
	@Autowired
	private ProjBoardService projboardService;
	
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
	
	/* 프로젝트 등록 form */
	@RequestMapping("/service/projectInsertform.do")
	public ModelAndView ProjectInsertform(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projectInsertform");
		return mView;
	}		

	
	/* 프로젝트 등록 */
	@RequestMapping("/service/projectInsert")
	public String projectInsert(HttpSession session,
			@ModelAttribute ProjBoardDto dto){
		String proj_writer = (String)session.getAttribute("id");
		System.out.println("작성자:"+proj_writer);
		dto.setProj_writer(proj_writer);
		dto.setProj_imagePath("default.png");
		dto.setProj_disp_tf(false);
		projboardService.insert(dto);
		
		return "redirect:/service/projectBoard.do";
	}

	/* 프로젝트 목록 */
	@RequestMapping("/service/projectBoard")
	public ModelAndView projectList(){
		ModelAndView mView=projboardService.list();
		mView.setViewName("service/projectBoard");
		return mView;
	}		
}
