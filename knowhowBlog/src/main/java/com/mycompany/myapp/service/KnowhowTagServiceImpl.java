package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.KnowhowTagDao;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;

@Service
public class KnowhowTagServiceImpl implements KnowhowTagService {

	@Autowired
	private KnowhowTagDao knowhowTagDao;	
	
	@Override
	public void insert(KnowhowDto dto) {
		String[] tags = dto.getTags();       

        for(int i=0;i<tags.length;i++) {
        	KnowhowTagDto tagDto = new KnowhowTagDto();
        	tagDto.setTag_kh_num(dto.getKh_num());
            tagDto.setTag_name(tags[i]);
            System.out.println("tagName"+tagDto.getTag_name());
        	knowhowTagDao.insert(tagDto);
        }	
	}

}
