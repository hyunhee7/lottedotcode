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
    
    /* 로그인 폼 */
    @RequestMapping("/members/loginform.do")
    public ModelAndView login(){
        List<String> list=new ArrayList<String>();
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", list);
        mView.setViewName("members/loginform");
        return mView;
    }
    
    /* 회원가입 폼 */
    @RequestMapping("/members/signupform.do")
    public ModelAndView signin(){
        List<String> list=new ArrayList<String>();
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", list);
        mView.setViewName("members/signupform");
        return mView;
    }        
    
    /* 회원가입 처리 */
    @RequestMapping("/members/signup")
    public ModelAndView signup(@ModelAttribute MembersDto dto,
            HttpServletRequest request) {
        String realPath=request.getSession().getServletContext().getRealPath("/upload");        
        dto = membersService.signup(dto, realPath);
        ModelAndView mView=new ModelAndView();
        mView.addObject("msg", dto.getId()+" 회원님! 가입이 완료되었습니다.");
        mView.addObject("url", "loginform.do");        
        mView.setViewName("members/alert");
        return mView;
    }

   /* 중복확인 시 ajax 이용하여 확인 하기 위한 로직 */ 
   @RequestMapping("/members/checkid")
   @ResponseBody 
   public Map<String, Object> checkid(@RequestParam String inputId){
      /* 들어오는 input id를 로직에 넣어 boolean으로 가져온다 */
      boolean canUse=membersService.canUseId(inputId);
      Map<String, Object> map=new HashMap<String, Object>();
      /* ajax로 처리할 것이므로 json형태로 반환 */
      map.put("canUse", canUse);
      return map;
   }       
   
   /* 로그인 처리 */
   @RequestMapping("/members/login")
   public ModelAndView signin(@ModelAttribute MembersDto dto, 
            HttpServletRequest request){
       
    boolean isValid = membersService.signin(dto);
    ModelAndView mView=new ModelAndView();        
    String url=request.getContextPath();
    if(isValid){
        request.getSession().setAttribute("id", dto.getId());
        mView.addObject("msg", dto.getId()+" 님 로그인 되었습니다.");
        mView.addObject("url", url);                
    }else{//아이디 혹은 비밀번호가 다른 경우 
        mView.addObject("msg", "아이디 혹은 비밀번호가 맞지 않습니다.");
        String location=request.getContextPath()+
         "/members/loginform.do";
        mView.addObject("url", location);
    }
    mView.setViewName("members/alert");
    return mView;
   }    
   
   /* 로그아웃 처리 */
   @RequestMapping("/members/logout")
   public ModelAndView signout(HttpSession session){
      session.invalidate();
      ModelAndView mView=new ModelAndView();
      mView.addObject("msg", "로그 아웃 되었습니다.");
      mView.addObject("url", session.getServletContext().getContextPath());
      mView.setViewName("members/alert");
      return mView;
   }      
   
}
