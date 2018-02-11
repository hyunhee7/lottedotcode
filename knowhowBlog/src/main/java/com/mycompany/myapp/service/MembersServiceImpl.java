package com.mycompany.myapp.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;
/* 회원 Service */
@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao membersDao;
	
	/* 회원가입 */
	@Override
	public ModelAndView signup(MembersDto dto, HttpServletRequest request) {
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
		dto.setUser_regr_id(dto.getId());
		dto.setUser_modr_id(dto.getId());
        //FileDao 객체를 이용해서 DB 에 저장하기
		membersDao.insert(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", dto.getId()+" 회원님! 가입이 완료되었습니다.");
		mView.addObject("url", "loginform.do");		
		return mView;
	}

	/* ID 사용가능 여부 */
	@Override
	public boolean canUseId(String id) {
		//사용가능한 아이디 인지 여부를 리턴받아서 
		boolean canUse=membersDao.canUseId(id);
		//리턴해준다. 
		return canUse;		
	}	
	
	/* 로그인 */
	@Override
	public ModelAndView signin(MembersDto dto, HttpServletRequest request) {
		boolean isValid=membersDao.isValid(dto);
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
		return mView;
	}	
	
	/* 프로필 사진 가져오기 */
	@Override
	public String getPath(String id) {
		String imgPath = membersDao.getPath(id);
		if(imgPath.isEmpty()) {
			imgPath="logo.png";
		}
		return imgPath;
	}	
}
