package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dto.ProjBoardDto;
/* 프로젝트 보드 Service */
@Service
public class ProjBoardServiceImpl implements ProjBoardService {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProjBoardDao projboardDao;
    
    /* 프로젝트 등록 */
    @Override
    public void insert(ProjBoardDto dto, String realPath) {
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setProj_imagePath("");
        }else {
            String orgFileName=mFile.getOriginalFilename();
            String filePath=realPath+File.separator;
            logger.info("프로젝트 사진 파일 경로"+filePath);
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
            dto.setProj_imagePath(saveFileName);
        }        
        projboardDao.insert(dto);
    }

    /* 프로젝트 리스트 */
    @Override
    public List<ProjBoardDto> list() {
        List<ProjBoardDto> list=projboardDao.getList();
        return list;
    }    
    
    /* 최근 프로젝트 리스트 */
    @Override
    public List<ProjBoardDto> recentList() {
        List<ProjBoardDto> list=projboardDao.getRecentList();
        return list;
    }    
    
    /* 프로젝트 상세보기 */
    @Override
    public ProjBoardDto detail(int proj_num) {
        ProjBoardDto dto = projboardDao.getDetail(proj_num);
        return dto;
    }
    
    /* 프로젝트 수정하기 */
    @Override
    public void update(ProjBoardDto dto, String realPath) {  
        if( dto.getUploadImage().isEmpty() ) {
            dto.setProj_imagePath("");
        }else {
            MultipartFile mFile=dto.getUploadImage();
            String orgFileName=mFile.getOriginalFilename();
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            File file=new File(filePath);
            if(!file.exists()){
                file.mkdir();
            }
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
                
        projboardDao.update(dto);
    }
    
    /* 프로젝트 삭제 */
    @Override
    public void delete(int proj_num) {
        projboardDao.delete(proj_num);
    }
}
