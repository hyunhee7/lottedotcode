package com.mycompany.myapp.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
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
        
        /* 프로필 사진이 없을 경우 공백 넣어준다. */
        if(dto.getUploadImage().isEmpty()) {
            dto.setImagePath("");
            String realPath=request.getSession().getServletContext().getRealPath("/upload");
            System.out.println(realPath);
        }else {
            //파일을 저장할 폴더의 절대 경로를 얻어온다.
            String realPath=request.getSession().getServletContext().getRealPath("/upload");
            System.out.println(realPath);
            
            //MultipartFile 객체의 참조값 얻어오기
            //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
            MultipartFile mFile=dto.getUploadImage();
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }
            //FileDto 객체에 추가 정보를 담는다.
            dto.setImagePath(saveFileName);
        }        
        dto = membersService.signup(dto);
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
    if(isValid){//아이디 비밀번호가 일치한 경우 
        //로그인 처리를 해준다.
        request.getSession().setAttribute("id", dto.getId());
        String id=(String)dto.getId();
        String imagePath=(String)dto.getImagePath();
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
      /* session 에 등록된 것을 무효화 시킨다 */
      session.invalidate();
      ModelAndView mView=new ModelAndView();
      mView.addObject("msg", "로그 아웃 되었습니다.");
      mView.addObject("url", session.getServletContext().getContextPath());
      mView.setViewName("members/alert");
      
      return mView;
   }      
   
}
