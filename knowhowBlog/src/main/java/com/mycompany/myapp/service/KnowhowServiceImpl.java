package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mycompany.myapp.dao.KnowhowDao;
import com.mycompany.myapp.dao.KnowhowTagDao;
import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
/* 노하우 Service */
@Service
public class KnowhowServiceImpl implements KnowhowService {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KnowhowDao knowhowDao;
    @Autowired
    private KnowhowTagDao knowhowTagDao;
    @Autowired
    private KnowhowTagService knowhowTagService;    
    /* 노하우 리스트 */
    @Override
    public List<KnowhowDto> list() {
        List<KnowhowDto> list = knowhowDao.getList();
        return list;
    }    

    /* 노하우 태그별 검색 */
    @Override
    public List<KnowhowDto> Searchlist(String tag_name) {
        List<Integer> kh_nums = knowhowTagDao.findPost_num(tag_name);
        List<KnowhowDto> list = knowhowDao.getSearchList(kh_nums);
        return list;
    }    

    /* 노하우 등록 */
    @Override
    public int insert(KnowhowDto dto, String id, String realPath) {
        dto.setKh_regr_id(id);
        dto.setKh_modr_id(id);
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setKh_filePath("");
        }else {
            String orgFileName=mFile.getOriginalFilename();
            long fileSize=mFile.getSize();
            String filePath=realPath+File.separator;
            logger.info("노하우 사진 파일 경로"+filePath);
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
            dto.setKh_filePath(saveFileName);
            dto.setKh_fileOrgName(orgFileName);
            dto.setKh_fileSize(fileSize);            
        }        
        int kh_num=knowhowDao.insert(dto);
        dto.setKh_num(kh_num);
        knowhowTagService.insert(dto);
        return kh_num;
    }

    /* 노하우 상세보기 */
    @Override
    public KnowhowDto detail(int kh_num) {
        KnowhowDto dto = knowhowDao.getDetail(kh_num);
        /* 태그 달기 */
        List<KnowhowTagDto> tags = knowhowDao.getTags(kh_num);
        dto.setPost_tag(tags);
        /* 댓글 달기 */
        List<KnowhowCommentDto> cmts = knowhowDao.getCmts(kh_num);
        dto.setCmts(cmts);
        return dto;
    }    

    /* 파일 다운로드 준비 */
    @Override
    public KnowhowDto getFile(int dtoNum) {
        KnowhowDto dto=knowhowDao.getFile(dtoNum);
        logger.info("다운로드파일 정보: "+dto.getKh_fileOrgName());
        return dto;
    }
    
    /* 노하우 수정 */
    @Override
    public void update(KnowhowDto dto, int kh_num, String id, String realPath) {
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setKh_filePath("");
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
            dto.setKh_filePath(saveFileName);
            dto.setKh_fileOrgName(orgFileName);
            dto.setKh_fileSize(fileSize);            
        }  
        dto.setKh_modr_id(id);
        dto.setKh_num(kh_num);
        knowhowTagService.update(dto);       
        knowhowDao.update(dto);
    }    
    
    /* 노하우 삭제 */
    @Override
    public void delete(int kh_num) {
        knowhowDao.delete(kh_num);
    }    
    
    /* 댓글 등록 */
    @Override
    public void cmtInsert(KnowhowCommentDto dto) {
        knowhowDao.cmtInsert(dto);
    }
    
    /* 최근 노하우 리스트 */
    @Override
    public List<KnowhowDto> recentList() {
        List<KnowhowDto> list=knowhowDao.getRecentList();
        return list;
    }        

}
