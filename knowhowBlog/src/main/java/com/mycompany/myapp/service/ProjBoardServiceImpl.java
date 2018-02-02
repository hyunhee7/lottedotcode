package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dto.ProjBoardDto;

@Service
public class ProjBoardServiceImpl implements ProjBoardService {

	@Autowired
	private ProjBoardDao projboardDao;
	
	@Override
	public void insert(ProjBoardDto dto, HttpServletRequest request) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( dto.getUploadImage().isEmpty() ) {
        	dto.setProj_imagePath("");
        }else {
            MultipartFile mFile=dto.getUploadImage();
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("사진세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }        	
            dto.setProj_imagePath(saveFileName);
        }

        //FileDto 객체에 추가 정보를 담는다.

        //FileDao 객체를 이용해서 DB 에 저장하기		
		
		projboardDao.insert(dto);
	}

	@Override
	public ModelAndView list() {
		List<ProjBoardDto> list=projboardDao.getList();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}	

}
