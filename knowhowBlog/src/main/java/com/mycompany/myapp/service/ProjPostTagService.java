package com.mycompany.myapp.service;


import com.mycompany.myapp.dto.ProjTimelineDto;
/* 포스트 태그 Service */
public interface ProjPostTagService {
	public void insert(ProjTimelineDto dto);	/* 포스트 태그 등록 */
	public void update(ProjTimelineDto dto);	/* 포스트 태그 수정 */
}
