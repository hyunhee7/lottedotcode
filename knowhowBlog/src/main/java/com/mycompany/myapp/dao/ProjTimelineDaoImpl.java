package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;

@Repository
public class ProjTimelineDaoImpl implements ProjTimelineDao{

	@Autowired
	private SqlSession session;
	
	/* 포스트 리스트 가져오기 */
	@Override
	public List<ProjTimelineDto> getList(int num){
		List<ProjTimelineDto> list = session.selectList("projTimeline.getList", num);
		return list;
	}

	/* 포스트 등록하기 */
	@Override
	public int insert(ProjTimelineDto dto) {
		session.insert("projTimeline.insert", dto);
		int post_num=dto.getPost_num();
		System.out.println("daoPostnum:"+post_num);
		return post_num;
	}

	/* 포스트 자세히 보기 */
	@Override
	public ProjTimelineDto getDetail(ProjTimelineDto dtoNum){
		ProjTimelineDto dto = session.selectOne("projTimeline.getDetail", dtoNum);
		return dto;
	}
	
	/* 포스트 다운로드 위한 경로 가져오기 */
	@Override
	public ProjTimelineDto getFile(ProjTimelineDto dtoNum){
		System.out.println("여긴 나오냐:"+dtoNum.getPost_num());
		ProjTimelineDto dto = session.selectOne("projTimeline.getFile", dtoNum);
		System.out.println("나와라:"+dto.getPost_fileOrgName());
		return dto;
	}
	
	/* 포스트에 등록된 태그 가져오기 */
	@Override
	public List<ProjPostTagDto> getTags(ProjTimelineDto dtoNum){
		List<ProjPostTagDto> tagDto = session.selectList("projPostTag.getTags", dtoNum);
		return tagDto;
	}	
	
	/* 포스트 수정하기 */
	@Override
	public void update(ProjTimelineDto dto) {
		session.insert("projTimeline.update", dto);
	}
	
	/* 포스트 삭제하기 */
	@Override
	public void delete(ProjTimelineDto dto) {
		session.delete("projTimeline.delete", dto);
	}	
	
	/* 댓글 등록하기 */
	@Override
	public void cmtInsert(ProjPostCommentDto dto) {
		session.insert("projTimeline.cmtinsert", dto);
	}
	
	/* 포스트 내 댓글 리스트 가져오기 */
	@Override
	public List<ProjPostCommentDto> getCmts(ProjTimelineDto dtoNum){
		List<ProjPostCommentDto> cmtDto = session.selectList("projTimeline.getCmts",dtoNum);
		return cmtDto;
	}	
}
