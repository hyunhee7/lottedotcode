package com.mycompany.myapp.dao;

import com.mycompany.myapp.dto.ProjPostTagDto;

public interface PostTagDao {
	public void insert(ProjPostTagDto dto);			/* 태그 등록하기 */
	public boolean findTag(ProjPostTagDto dto);		/* 이미 등록된 태그인지 확인하기 */
}
