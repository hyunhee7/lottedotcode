package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
import com.mycompany.myapp.service.ProjBoardService;
import com.mycompany.myapp.service.ProjTimelineService;
import com.mycompany.myapp.service.ProjTimelineServiceImpl;



@Controller
public class ServiceController {
	
	@Autowired
	private ProjBoardService projboardService;
	@Autowired
	private ProjTimelineService projTimelineService;
	
	@RequestMapping("/service/main.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/main");
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
	public String projectInsert(HttpSession session,HttpServletRequest request,
			@ModelAttribute ProjBoardDto dto){
		String proj_writer = (String)session.getAttribute("id");
		System.out.println("작성자:"+proj_writer);
		dto.setProj_writer(proj_writer);
		dto.setProj_disp_tf(false);
		projboardService.insert(dto,request);
		
		return "redirect:/service/projectBoard.do";
	}

	/* 프로젝트 목록 */
	@RequestMapping("/service/projectBoard")
	public ModelAndView projectList(){
		ModelAndView mView=projboardService.list();
		mView.setViewName("service/projectBoard");
		return mView;
	}	
	
	/* 프로젝트 Timeline 목록 */
	@RequestMapping("/service/projectTimeline.do")
	public ModelAndView projectTimeline(@RequestParam int num, HttpSession session){
		ModelAndView mView=projTimelineService.list(num);
		mView.setViewName("service/projectTimeline");
		return mView;
	}	
	
	/* 포스트 등록 form */
	@RequestMapping("/service/projPostInsertform.do")
	public ModelAndView PostInsertform(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/projPostInsertform");
		return mView;
	}

	/*	포스트 등록 */ 
	@RequestMapping("/service/projPostInsert")
	public String postInsert(HttpSession session, HttpServletRequest request,
			@ModelAttribute ProjTimelineDto dto){
		System.out.println("오잉 들어옴");
		String post_regr_id = (String)session.getAttribute("id");
		System.out.println(request.getAttribute("proj_num"));
		String proj_num = (String)request.getAttribute("proj_num");
		System.out.println(proj_num);
		int post_proj_num = Integer.parseInt(proj_num);
		System.out.println(post_regr_id);
		System.out.println(request.getAttribute("proj_num"));
		//int post_proj_num = (Integer)request.getAttribute("proj_num");
		System.out.println();
		dto.setPost_regr_id(post_regr_id);
		dto.setPost_modr_id(post_regr_id);
		dto.setPost_proj_num(post_proj_num);
		projTimelineService.insert(dto,request);
		
		return "redirect:/service/projectTimeline.do";
	}
	
}
