package com.mycompany.myapp.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;
/* 회원 Service */
@Service
public class MembersServiceImpl implements MembersService {

    @Autowired
    private MembersDao membersDao;
    
    /* 회원가입 */
    @Override
    public MembersDto signup(MembersDto dto, String realPath) {
        if(dto.getUploadImage().isEmpty()) {
            dto.setImagePath("");
            System.out.println(realPath);
        }else {
            System.out.println(realPath);
            MultipartFile mFile=dto.getUploadImage();
            String orgFileName=mFile.getOriginalFilename();
            String filePath=realPath+File.separator;
            File file=new File(filePath);
            if(!file.exists()){
                file.mkdir();
            }
            String saveFileName=System.currentTimeMillis()+orgFileName;
            try{
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
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
