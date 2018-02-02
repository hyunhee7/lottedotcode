package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.PostTagDao;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;

@Service
public class ProjPostTagServiceImpl implements ProjPostTagService {

	@Autowired
	private PostTagDao postTagDao;
	
	@Override
	public void insert(ProjTimelineDto dto) {
        
		String[] tags = dto.getTags();       

        for(int i=0;i<tags.length;i++) {
        	ProjPostTagDto tagDto = new ProjPostTagDto();
        	tagDto.setTag_post_num(dto.getPost_num());
        	tagDto.setTag_proj_num(dto.getPost_proj_num());
            tagDto.setTag_name(tags[i]);
            System.out.println("tagName"+tagDto.getTag_name());
            System.out.println("PostNum"+tagDto.getTag_post_num());
            System.out.println("ProjNum"+tagDto.getTag_proj_num());
        	postTagDao.insert(tagDto);
        }		
	}

}
