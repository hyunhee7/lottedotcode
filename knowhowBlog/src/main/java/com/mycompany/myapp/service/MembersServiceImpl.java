package com.mycompany.myapp.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;

@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao membersDao;

	@Override
	public ModelAndView signup(MembersDto dto, HttpServletRequest request) {
		System.out.println("들어옴2");
		
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
        //FileDao 객체를 이용해서 DB 에 저장하기
		membersDao.insert(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", dto.getId()+" 회원님! 가입이 완료되었습니다.");
		mView.addObject("url", request.getContextPath());		
		return mView;
	}

}
