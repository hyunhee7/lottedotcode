package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
/* 프로젝트 타임라인 Service */
@Service
public class ProjTimelineServiceImpl implements ProjTimelineService{
	
	@Autowired
	private ProjTimelineDao projTimelineDao;
	@Autowired
	private ProjBoardDao projBoardDao;	
	
	/* 포스트 리스트  */
	@Override
	public ModelAndView list(int num) {
		/* 포스트 리스트 가져오기 */
		List<ProjTimelineDto> list = projTimelineDao.getList(num);
		/* 프로젝트 내용 가져오기 */
		ProjBoardDto pdto= projBoardDao.getDetail(num);
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		mView.addObject("pdto", pdto);
		return mView;
	}

	/* 포스트 등록하기 */
	@Override
	public int insert(ProjTimelineDto dto, HttpServletRequest request) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        MultipartFile mFile=dto.getUploadImage();
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( mFile.isEmpty() ) {
        	dto.setPost_filePath("");
        	
        }else {
            
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
            dto.setPost_filePath(saveFileName);
    		dto.setPost_fileOrgName(orgFileName);
    		dto.setPost_fileSize(fileSize);            
        }
		int post_num=projTimelineDao.insert(dto);
		return post_num;
	}
	
	/* 포스트 상세보기 */
	@Override
	public ModelAndView detail(ProjTimelineDto dtoNum) {
		/* 포스트 상세 내용 가져오기 */
		ProjTimelineDto dto = projTimelineDao.getDetail(dtoNum);
		/* 포스트 태그 가져오기 */
		List<ProjPostTagDto> tags = projTimelineDao.getTags(dtoNum);
		dto.setPost_tag(tags);
		/* 포스트 댓글 리스트 가져오기 */
		List<ProjPostCommentDto> cmts = projTimelineDao.getCmts(dtoNum);
		dto.setCmts(cmts);		
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}	

	/* 포스트 내 첨부파일 다운로드 준비 */
	@Override
	public ModelAndView getFile(ProjTimelineDto dtoNum) {
		//다운로드 시켜줄 파일의 정보를 DB 에서 얻어오고
		ProjTimelineDto dto=projTimelineDao.getFile(dtoNum);
		//ModelAndView 객체에 담아서
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto",dto);
		//리턴해준다.
		return mView;
	}
	
	/* 포스트 수정 */
	@Override
	public void update(ProjTimelineDto dto, HttpServletRequest request) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        MultipartFile mFile=dto.getUploadImage();
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( mFile.isEmpty() ) {
        	dto.setPost_filePath(""); 
        }else {
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
            dto.setPost_filePath(saveFileName);
    		dto.setPost_fileOrgName(orgFileName);
    		dto.setPost_fileSize(fileSize);            
        }
        projTimelineDao.update(dto);
	}	
	
	/* 포스트 삭제 */
	@Override
	public void delete(ProjTimelineDto dto) {
		projTimelineDao.delete(dto);
	}	
	
	/* 포스트 댓글 등록 */
	@Override
	public void cmtInsert(ProjPostCommentDto dto) {
		projTimelineDao.cmtInsert(dto);
	}	
	
	
}
