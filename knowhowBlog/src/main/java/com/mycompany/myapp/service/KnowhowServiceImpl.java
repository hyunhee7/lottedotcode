package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.KnowhowDao;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;

@Service
public class KnowhowServiceImpl implements KnowhowService {

	@Autowired
	private KnowhowDao knowhowDao;
	
	@Override
	public ModelAndView list() {
		List<KnowhowDto> list = knowhowDao.getList();
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}	
	
	
	@Override
	public int insert(KnowhowDto dto, HttpServletRequest request) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        int post_num;
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( dto.getUploadImage().isEmpty() ) {
        	dto.setKh_filePath("");
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
            System.out.println("세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }        	
            dto.setKh_filePath(saveFileName);
    		dto.setKh_fileOrgName(orgFileName);
    		dto.setKh_fileSize(fileSize);            
        }
        

		post_num=knowhowDao.insert(dto);
		System.out.println("post_num:"+post_num);

		return post_num;
	}

	@Override
	public ModelAndView detail(KnowhowDto dtoNum) {

		KnowhowDto dto = knowhowDao.getDetail(dtoNum);
		List<KnowhowTagDto> tags = knowhowDao.getTags(dtoNum);
		dto.setPost_tag(tags);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}	

	@Override
	public ModelAndView getFile(KnowhowDto dtoNum) {

		//다운로드 시켜줄 파일의 정보를 DB 에서 얻어오고
		KnowhowDto dto=knowhowDao.getFile(dtoNum);
		//ModelAndView 객체에 담아서
		System.out.println(dto.getKh_fileOrgName());
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto",dto);
		//리턴해준다.
		return mView;
	}
	
	@Override
	public void update(KnowhowDto dto, HttpServletRequest request) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        int post_num;
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( dto.getUploadImage().isEmpty() ) {
        	dto.setKh_filePath("");
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
            System.out.println("세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }        	
            dto.setKh_filePath(saveFileName);
    		dto.setKh_fileOrgName(orgFileName);
    		dto.setKh_fileSize(fileSize);            
        }
        
        knowhowDao.update(dto);
	}	

}
