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
	
	@Override
	public List<ProjTimelineDto> getList(int num){
		List<ProjTimelineDto> list = session.selectList("projTimeline.getList", num);
		return list;
	}

	@Override
	public int insert(ProjTimelineDto dto) {
		session.insert("projTimeline.insert", dto);
		int post_num=dto.getPost_num();
		System.out.println("daoPostnum:"+post_num);
		return post_num;
	}

	
	@Override
	public ProjTimelineDto getDetail(ProjTimelineDto dtoNum){
		ProjTimelineDto dto = session.selectOne("projTimeline.getDetail", dtoNum);
		return dto;
	}
	
	@Override
	public ProjTimelineDto getFile(ProjTimelineDto dtoNum){
		System.out.println("여긴 나오냐:"+dtoNum.getPost_num());
		ProjTimelineDto dto = session.selectOne("projTimeline.getFile", dtoNum);
		System.out.println("나와라:"+dto.getPost_fileOrgName());
		return dto;
	}
	
	@Override
	public List<ProjPostTagDto> getTags(ProjTimelineDto dtoNum){
		List<ProjPostTagDto> tagDto = session.selectList("projPostTag.getTags", dtoNum);
		return tagDto;
	}	
	
	@Override
	public void update(ProjTimelineDto dto) {
		session.insert("projTimeline.update", dto);
	}
	
	@Override
	public void delete(ProjTimelineDto dto) {
		session.delete("projTimeline.delete", dto);
	}	
	
	@Override
	public void cmtInsert(ProjPostCommentDto dto) {
		session.insert("projTimeline.cmtinsert", dto);
	}
	
	@Override
	public List<ProjPostCommentDto> getCmts(ProjTimelineDto dtoNum){
		List<ProjPostCommentDto> cmtDto = session.selectList("projTimeline.getCmts",dtoNum);
		return cmtDto;
	}	
}
