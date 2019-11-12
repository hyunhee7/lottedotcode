package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
/* 프로젝트 타임라인 Service */
@Service
public class ProjTimelineServiceImpl implements ProjTimelineService{
	
	@Autowired
	private ProjTimelineDao projTimelineDao;
	@Autowired
	private ProjBoardDao projBoardDao;	
	
	/* 포스트 리스트  */
	/*	

	@Override
	public ModelAndView list(int num) {


		return mView;
	}
	 */
	
	/* 포스트 등록하기 */
	@Override
	public int insert(ProjTimelineDto dto) {
		int post_num=projTimelineDao.insert(dto);
		return post_num;
	}
	
	/* 포스트 상세보기 */
	@Override
	public ProjTimelineDto detail(ProjTimelineDto dtoNum) {
		/* 포스트 상세 내용 가져오기 */
		ProjTimelineDto dto = projTimelineDao.getDetail(dtoNum);
		/* 포스트 태그 가져오기 */
		List<ProjPostTagDto> tags = projTimelineDao.getTags(dtoNum);
		dto.setPost_tag(tags);
		/* 포스트 댓글 리스트 가져오기 */
		List<ProjPostCommentDto> cmts = projTimelineDao.getCmts(dtoNum);
		dto.setCmts(cmts);		
		return dto;
	}	

	/* 포스트 내 첨부파일 다운로드 준비 */
	@Override
	public ProjTimelineDto getFile(ProjTimelineDto dtoNum) {
		//다운로드 시켜줄 파일의 정보를 DB 에서 얻어오고
		ProjTimelineDto dto=projTimelineDao.getFile(dtoNum);
		return dto;
	}
	
	/* 포스트 수정 */
	@Override
	public void update(ProjTimelineDto dto) {
        projTimelineDao.update(dto);
	}	
	
	/* 포스트 삭제 */
	@Override
	public void delete(ProjTimelineDto dto) {
		projTimelineDao.delete(dto);
	}	
	
	/* 포스트 댓글 등록 */
	@Override
	public void cmtInsert(ProjPostCommentDto dto) {
		projTimelineDao.cmtInsert(dto);
	}	
	
	
}
