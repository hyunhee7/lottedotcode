package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
/* 프로젝트 타임라인 Service */
@Service
public class ProjTimelineServiceImpl implements ProjTimelineService{
    public Logger logger = LoggerFactory.getLogger(this.getClass());    
    @Autowired
    private ProjTimelineDao projTimelineDao; 
    @Autowired
    private ProjPostTagService projPostTagService;    
    
    /* 포스트 등록하기 */
    @Override
    public void insert(ProjTimelineDto dto, String realPath) {
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setPost_filePath("");
            
        }else {
            String orgFileName=mFile.getOriginalFilename();
            long fileSize=mFile.getSize();
            String filePath=realPath+File.separator;
            logger.info("포스트 사진 파일 경로"+filePath);
            File file=new File(filePath);
            if(!file.exists()){
                file.mkdir();
            }
            String saveFileName=System.currentTimeMillis()+orgFileName;
            logger.info("등록된 파일명:"+saveFileName);
            try{
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                logger.error("fail to process file", e);
            }            
            dto.setPost_filePath(saveFileName);
            dto.setPost_fileOrgName(orgFileName);
            dto.setPost_fileSize(fileSize);            
        }        
        int post_num=projTimelineDao.insert(dto);
        dto.setPost_num(post_num);
        projPostTagService.insert(dto);
    }
    
    /* 포스트 상세보기 */
    @Override
    public ProjTimelineDto detail(ProjTimelineDto dtoNum) {
        /* 포스트 상세 내용 가져오기 */
        ProjTimelineDto dto = projTimelineDao.getDetail(dtoNum);
        /* 포스트 태그 가져오기 */
        List<ProjPostTagDto> tags = projTimelineDao.getTags(dtoNum);
        dto.setPost_tag(tags);
        /* 포스트 댓글 리스트 가져오기 */
        List<ProjPostCommentDto> cmts = projTimelineDao.getCmts(dtoNum);
        dto.setCmts(cmts);        
        return dto;
    }    

    /* 포스트 내 첨부파일 다운로드 준비 */
    @Override
    public ProjTimelineDto getFile(ProjTimelineDto dtoNum) {
        ProjTimelineDto dto=projTimelineDao.getFile(dtoNum);
        return dto;
    }
    
    /* 포스트 수정 */
    @Override
    public void update(ProjTimelineDto dto, String realPath) {
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setPost_filePath(""); 
        }else {
            String orgFileName=mFile.getOriginalFilename();
            long fileSize=mFile.getSize();
            String filePath=realPath+File.separator;
            logger.info("수정된 파일경로:"+filePath);
            File file=new File(filePath);
            if(!file.exists()){
                file.mkdir();
            }
            String saveFileName=System.currentTimeMillis()+orgFileName;
            logger.info("수정된 세이프파일:"+saveFileName);
            try{
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                logger.error("fail to process file", e);
            }            
            dto.setPost_filePath(saveFileName);
            dto.setPost_fileOrgName(orgFileName);
            dto.setPost_fileSize(fileSize);            
        }
        projTimelineDao.update(dto);
        projPostTagService.update(dto);
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
