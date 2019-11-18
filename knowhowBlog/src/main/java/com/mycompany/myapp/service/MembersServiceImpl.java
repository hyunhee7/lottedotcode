package com.mycompany.myapp.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;
/* 회원 Service */
@Service
public class MembersServiceImpl implements MembersService {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MembersDao membersDao;
    
    /* 회원가입 */
    @Override
    public MembersDto signup(MembersDto dto, String realPath) {
        if(dto.getUploadImage().isEmpty()) {
            dto.setImagePath("");
        }else {
            MultipartFile mFile=dto.getUploadImage();
            String orgFileName=mFile.getOriginalFilename();
            String filePath=realPath+File.separator;
            logger.info("프로필 사진 파일 경로"+filePath);
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
            dto.setImagePath(saveFileName);
        }        
        dto.setUser_regr_id(dto.getId());
        dto.setUser_modr_id(dto.getId());
        membersDao.insert(dto);
        return dto;
    }

    /* ID 사용가능 여부 */
    @Override
    public boolean canUseId(String id) {
        boolean canUse=membersDao.canUseId(id);
        return canUse;        
    }    
    
    /* 로그인 */
    @Override
    public boolean signin(MembersDto dto) {
        boolean isValid=membersDao.isValid(dto);
        return isValid;
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
