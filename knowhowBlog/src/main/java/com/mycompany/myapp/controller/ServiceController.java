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

import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
import com.mycompany.myapp.service.KnowhowService;
import com.mycompany.myapp.service.KnowhowTagService;
import com.mycompany.myapp.service.ProjBoardService;
import com.mycompany.myapp.service.ProjPostTagService;
import com.mycompany.myapp.service.ProjTimelineService;



@Controller
public class ServiceController {
	
	@Autowired
	private ProjBoardService projboardService;
	@Autowired
	private ProjTimelineService projTimelineService;
	@Autowired
	private ProjPostTagService projPostTagService;
	@Autowired
	private KnowhowService knowhowService;
	@Autowired
	private KnowhowTagService knowhowTagService;	
	
	@RequestMapping("/service/main.do")
	public ModelAndView login(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/main");
		return mView;
	}

	/* 노하우 리스트 */
	@RequestMapping("/service/knowhowList.do")
	public ModelAndView knowhowList(){
		ModelAndView mView=knowhowService.list();
		mView.setViewName("service/knowhowList");
		return mView;		
	}	
	
	/* 노하우 등록 form */
	@RequestMapping("/service/knowhowInsertform.do")
	public ModelAndView knowhowInsertform(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("service/knowhowInsertform");
		return mView;
	}
	
	/*	노하우 등록 */ 
	@RequestMapping("/service/knowhowInsert")
	public String knowhowInsert(HttpSession session, HttpServletRequest request,
			@ModelAttribute KnowhowDto dto){
		System.out.println("노하우 들어옴");
		String kh_regr_id = (String)session.getAttribute("id");
		System.out.println("등록자:"+kh_regr_id);
	
		dto.setKh_regr_id(kh_regr_id);
		dto.setKh_modr_id(kh_regr_id);
		
		/* autoIncrement 이후에 kh_num을 가져와 넣은 후 Tag 넣는 작업을 한다 */
		try {
			int post_num = knowhowService.insert(dto, request);
			dto.setKh_num(post_num);
			System.out.println("post_num직후:"+dto.getKh_num());
		}catch(Exception ex){
			
		}finally {
			knowhowTagService.insert(dto);
		}
		
		
		return "redirect:/service/knowhowList.do";
	}	
	
	/* 노하우 상세보기 */
	@RequestMapping("/service/knowhowDetail.do")
	public ModelAndView knowhowDetail(HttpServletRequest request, HttpSession session){

	    int kh_num=Integer.parseInt(request.getParameter("kh_num"));
		System.out.println("detailPROJ_NUM:"+kh_num);
		KnowhowDto dtoNum = new KnowhowDto();
		dtoNum.setKh_num(kh_num);
		ModelAndView mView=knowhowService.detail(dtoNum);
		mView.setViewName("service/knowhowDetail");
		return mView;
	}
	
	/* 노하우 파일 다운로드 */
	@RequestMapping("/service/khFileDownload")
	public ModelAndView khdownload(HttpServletRequest request){
		//다운로드할 파일의 정보를 ModelAndView 객체에 담아서 리턴 받는다.
    	int kh_num=Integer.parseInt(request.getParameter("kh_num"));
		KnowhowDto dtoNum = new KnowhowDto();
		dtoNum.setKh_num(kh_num);
		ModelAndView mView=knowhowService.getFile(dtoNum);
		//파일을 다운로드 시켜줄 view 객체의 이름을 지정하고
		System.out.println("fileDoawnload여긴 옴.");
		mView.setViewName("khfileDownView");
		//리턴해준다.
		return mView;
	}		
	
	/* 노하우 수정 form */
	@RequestMapping("/service/knowhowUpdateform.do")
	public ModelAndView knowhowUpdateform(HttpServletRequest request){
		int kh_num = Integer.parseInt(request.getParameter("kh_num"));
		KnowhowDto dtoNum = new KnowhowDto();
		dtoNum.setKh_num(kh_num);
		ModelAndView mView=knowhowService.detail(dtoNum);
		mView.setViewName("service/knowhowUpdateform");
		return mView;
	}
	
	/*	노하우 수정 */ 
	@RequestMapping("/service/knowhowUpdate.do")
	public String knowhowUpdate(HttpSession session, HttpServletRequest request,
			@ModelAttribute KnowhowDto dto){
		System.out.println("노하우 들어옴");
		
		// 수정한 사람 id 가져와서 modr_id 변경
		String kh_modr_id = (String)session.getAttribute("id");
		System.out.println("변경자:"+kh_modr_id);
		dto.setKh_modr_id(kh_modr_id);
		int kh_num = dto.getKh_num();
		System.out.println("수정할때 khnum:"+kh_num);
		try {
			knowhowService.update(dto, request);
			dto.setKh_num(kh_num);
			System.out.println("post_num직후:"+dto.getKh_num());
		}catch(Exception ex){
			
		}finally {
			knowhowTagService.update(dto);
		}
		
		
		return "redirect:/service/knowhowDetail.do?kh_num="+kh_num;
	}
	
	/* 노하우 삭제 */
	@RequestMapping("/service/knowhowDelete.do")
	public String knowhowDelete(HttpSession session,HttpServletRequest request) {
		int kh_num = Integer.parseInt(request.getParameter("kh_num"));
		knowhowService.delete(kh_num);
		
		return "redirect:/service/knowhowList.do";
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
	
	/* 포스트 수정 form */
	@RequestMapping("/service/postUpdateform.do")
	public ModelAndView postUpdateform(HttpServletRequest request){
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		int proj_num = Integer.parseInt(request.getParameter("proj_num"));
		ProjTimelineDto dtoNum = new ProjTimelineDto();
		dtoNum.setPost_num(post_num);
		dtoNum.setPost_proj_num(proj_num);
		ModelAndView mView=projTimelineService.detail(dtoNum);
		mView.setViewName("service/postUpdateform");
		return mView;
	}
	
	/* 포스트 수정 */ 
	@RequestMapping("/service/postUpdate.do")
	public String postUpdate(HttpSession session, HttpServletRequest request,
			@ModelAttribute ProjTimelineDto dto){
		System.out.println("포스트update 들어옴");
		
		// 수정한 사람 id 가져와서 modr_id 변경
		String post_modr_id = (String)session.getAttribute("id");
		System.out.println("변경자:"+post_modr_id);
		dto.setPost_modr_id(post_modr_id);
		int post_num = dto.getPost_num();
		int post_proj_num = dto.getPost_proj_num();
		System.out.println("수정할때 post_num:"+post_num+post_proj_num);
		try {
			projTimelineService.update(dto, request);
			dto.setPost_num(post_num);
			dto.setPost_proj_num(post_proj_num);
			System.out.println("post_num직후:"+dto.getPost_num());
		}catch(Exception ex){
			
		}finally {
			projPostTagService.update(dto);
		}
		
		
		return "redirect:/service/projPostDetail.do?post_proj_num="+post_proj_num+"&post_num="+post_num;
	}
	
	/* 포스트 삭제 */
	@RequestMapping("/service/postDelete.do")
	public String postDelete(HttpSession session,HttpServletRequest request) {
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		int post_proj_num = Integer.parseInt(request.getParameter("post_proj_num"));
		ProjTimelineDto dto = new ProjTimelineDto();
		dto.setPost_num(post_num);
		dto.setPost_proj_num(post_proj_num);
		projTimelineService.delete(dto);
		
		return "redirect:/service/projectTimeline.do?num="+post_proj_num;
	}	

	/* 포스트 파일 다운로드 */
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
