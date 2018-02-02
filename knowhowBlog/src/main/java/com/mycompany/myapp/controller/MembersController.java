package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

   // 중복확인 ajax 요청 처리 
   @RequestMapping("/members/checkid")
   @ResponseBody 
   public Map<String, Object> checkid(@RequestParam String inputId){
      boolean canUse=membersService.canUseId(inputId);
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("canUse", canUse);
      System.out.println("controller:"+canUse);
      return map;
   }   	
   
   // 로그인
   @RequestMapping("/members/login")
   public ModelAndView signin(@ModelAttribute MembersDto dto, 
            HttpServletRequest request){
      ModelAndView mView=membersService.signin(dto, request);
      mView.setViewName("members/alert");
      return mView;
   }    
   
   @RequestMapping("/members/logout")
   public ModelAndView signout(HttpSession session){
      //로그 아웃 처리
      session.invalidate();
      ModelAndView mView=new ModelAndView();
      mView.addObject("msg", "로그 아웃 되었습니다.");
      mView.addObject("url", 
            session.getServletContext().getContextPath());
      mView.setViewName("members/alert");
      
      return mView;
   }      
   
}
