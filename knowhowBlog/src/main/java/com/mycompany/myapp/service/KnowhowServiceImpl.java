package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.KnowhowDao;
import com.mycompany.myapp.dao.KnowhowTagDao;
import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
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
            System.out.println("파일 경로"+filePath);

            File file=new File(filePath);
            if(!file.exists()){
                file.mkdir();
            }
            String saveFileName=System.currentTimeMillis()+orgFileName;
            logger.info("등록된 파일명:"+saveFileName);
            try{
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
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
    public KnowhowDto detail(KnowhowDto dtoNum, int num) {
        dtoNum.setKh_num(num);
        KnowhowDto dto = knowhowDao.getDetail(dtoNum);
        List<KnowhowTagDto> tags = knowhowDao.getTags(dtoNum);
        dto.setPost_tag(tags);
        List<KnowhowCommentDto> cmts = knowhowDao.getCmts(dtoNum);
        dto.setCmts(cmts);
        return dto;
    }    

    /* 파일 다운로드 준비 */
    @Override
    public KnowhowDto getFile(KnowhowDto dtoNum) {
        //다운로드 시켜줄 파일의 정보를 DB 에서 얻어오고
        KnowhowDto dto=knowhowDao.getFile(dtoNum);
        System.out.println(dto.getKh_fileOrgName());
        //리턴해준다.
        return dto;
    }
    
    /* 노하우 수정 */
    @Override
    public void update(KnowhowDto dto) {
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
