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
import com.mycompany.myapp.service.ProjPostTagService;
import com.mycompany.myapp.service.ProjTimelineService;
import com.mycompany.myapp.service.ProjTimelineServiceImpl;



@Controller
public class ServiceController {
	
	@Autowired
	private ProjBoardService projboardService;
	@Autowired
	private ProjTimelineService projTimelineService;
	@Autowired
	private ProjPostTagService projPostTagService;
	
	@RequestMapping("/service/main.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/main");
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
		System.out.println("등록자:"+post_regr_id);
		System.out.println(dto.getPost_proj_num()); 
		//int post_proj_num = (Integer)request.getAttribute("proj_num");
		int post_proj_num = dto.getPost_proj_num();
		dto.setPost_proj_num(post_proj_num);
		System.out.println("프로젝트넘:"+dto.getPost_proj_num());		
		dto.setPost_regr_id(post_regr_id);
		dto.setPost_modr_id(post_regr_id);
		
		try {
			int post_num = projTimelineService.insert(dto, request);
			dto.setPost_num(post_num);
			System.out.println("post_num직후:"+dto.getPost_num());
		}catch(Exception ex){
			
		}finally {
			projPostTagService.insert(dto);
		}
		
		
		return "redirect:/service/projectTimeline.do?num="+post_proj_num;
	}
	
	/* 포스트 상세보기 */
	@RequestMapping("/service/projPostDetail.do")
	public ModelAndView projectDetail(HttpServletRequest request, HttpSession session){

	    int proj_num = 0;
	    int post_num = 0;

    	proj_num=Integer.parseInt(request.getParameter("proj_num"));
    	post_num=Integer.parseInt(request.getParameter("post_num"));
		System.out.println("detailPROJ_NUM:"+proj_num);
		System.out.println("detailPOST_NUM:"+post_num);
		ProjTimelineDto dtoNum = new ProjTimelineDto();
		dtoNum.setPost_proj_num(proj_num);
		dtoNum.setPost_num(post_num);
		ModelAndView mView=projTimelineService.detail(dtoNum);
		mView.setViewName("service/projPostDetail");
		return mView;
	}
	
	@RequestMapping("/service/FileDownload")
	public ModelAndView download(HttpServletRequest request){
		//다운로드할 파일의 정보를 ModelAndView 객체에 담아서 리턴 받는다.
    	int post_proj_num=Integer.parseInt(request.getParameter("proj_num"));
    	int post_num=Integer.parseInt(request.getParameter("post_num"));
		ProjTimelineDto dtoNum = new ProjTimelineDto();
		dtoNum.setPost_proj_num(post_proj_num);
		dtoNum.setPost_num(post_num);
		ModelAndView mView=projTimelineService.getFile(dtoNum);
		//파일을 다운로드 시켜줄 view 객체의 이름을 지정하고
		System.out.println("fileDoawnload여긴 옴.");
		mView.setViewName("fileDownView");
		//리턴해준다.
		return mView;
		
	}	
	
}
