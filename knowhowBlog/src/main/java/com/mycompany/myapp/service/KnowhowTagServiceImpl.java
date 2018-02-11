package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.KnowhowTagDao;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
/* 노하우 태그 Service */
@Service
public class KnowhowTagServiceImpl implements KnowhowTagService {

	@Autowired
	private KnowhowTagDao knowhowTagDao;	
	
	/* 노하우 등록 */
	@Override
	public void insert(KnowhowDto dto) {
		/* 등록된 태그를 가져와 배열에 등록 */
		String[] tags = dto.getTags();
		/* 배열 길이만큼 for문 돌며 Dto에 넣고 DB에 등록 */
        for(int i=0;i<tags.length;i++) {
        	KnowhowTagDto tagDto = new KnowhowTagDto();
        	tagDto.setTag_kh_num(dto.getKh_num());
            tagDto.setTag_name(tags[i]);
        	knowhowTagDao.insert(tagDto);
        }	
	}
	
	/* 노하우 수정시 태그 등록 - DB에 없는 경우만 태그를 새로 입력 */
	@Override
	public void update(KnowhowDto dto) {
		String[] tags = dto.getTags();       
		KnowhowTagDto tagDto = new KnowhowTagDto();

        for(int i=0;i<tags.length;i++) {
        	String tag_name = tags[i];
    		tagDto.setTag_name(tag_name);
        	tagDto.setTag_kh_num(dto.getKh_num());
        	boolean exist = knowhowTagDao.findTag(tagDto);
        	if(exist) {
        		continue;
        	}else {
            	knowhowTagDao.insert(tagDto);
        	}
        }	
	}	

}
