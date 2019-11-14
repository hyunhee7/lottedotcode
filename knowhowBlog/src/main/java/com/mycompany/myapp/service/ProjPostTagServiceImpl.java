package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.PostTagDao;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
/* 포스트 태그 Service */
@Service
public class ProjPostTagServiceImpl implements ProjPostTagService {

    @Autowired
    private PostTagDao postTagDao;
    
    /* 포스트 태그 등록 */
    @Override
    public void insert(ProjTimelineDto dto) {
        
        String[] tags = dto.getTags();       

        for(int i=0;i<tags.length;i++) {
            ProjPostTagDto tagDto = new ProjPostTagDto();
            tagDto.setTag_post_num(dto.getPost_num());
            tagDto.setTag_proj_num(dto.getPost_proj_num());
            tagDto.setTag_name(tags[i]);
            postTagDao.insert(tagDto);
        }        
    }
    
    /* 태그 수정 - 등록되지않은 태그만 DB에 등록 시킨다. */
    @Override
    public void update(ProjTimelineDto dto) {
        String[] tags = dto.getTags();       
        ProjPostTagDto tagDto = new ProjPostTagDto();

        for(int i=0;i<tags.length;i++) {

            String tag_name = tags[i];
            tagDto.setTag_name(tag_name);
            tagDto.setTag_post_num(dto.getPost_num());
            tagDto.setTag_proj_num(dto.getPost_proj_num());
            boolean exist = postTagDao.findTag(tagDto);
            System.out.println("exist:"+exist);
            if(exist) {
                continue;
            }else {
                System.out.println("tagName"+tagDto.getTag_name());
                postTagDao.insert(tagDto);
            }
        }    
        
        // 이전에 추가한 Tag를 지운 경우 
        
    }    
}
