package com.mycompany.myapp.service;

import com.mycompany.myapp.dto.KnowhowDto;
/* 노하우 태그 Service */
public interface KnowhowTagService {
	public void insert(KnowhowDto dto);	/* 노하우 태그 등록 */
	public void update(KnowhowDto dto);	/* 노하우 태그 수정 */
}
