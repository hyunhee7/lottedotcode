package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjTimelineDto;

/* 프로젝트 타임라인 Service */
public interface ProjTimelineService {
	public int insert(ProjTimelineDto dto);									/* 포스트 등록 */
//	public ProjTimelineDto list(int num);									/* 포스트 리스트  */
	public ProjTimelineDto detail(ProjTimelineDto dto);						/* 포스트 상세보기 */
	public ProjTimelineDto getFile(ProjTimelineDto dtoNum);					/* 포스트 파일 다운로드 준비 */
	public void update(ProjTimelineDto dto);	/* 포스트 수정 */
	public void delete(ProjTimelineDto dto);								/* 포스트 삭제 */
	public void cmtInsert(ProjPostCommentDto dto);							/* 포스트 댓글 등록 */
}
