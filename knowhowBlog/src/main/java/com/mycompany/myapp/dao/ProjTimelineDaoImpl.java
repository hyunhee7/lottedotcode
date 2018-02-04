package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		int post_num = dto.getPost_num();
		return post_num;
	}

	
	@Override
	public ProjTimelineDto getDetail(ProjTimelineDto dtoNum){
		ProjTimelineDto dto = session.selectOne("projTimeline.getDetail", dtoNum);
		return dto;
	}
	
	@Override
	public List<ProjPostTagDto> getTags(ProjTimelineDto dtoNum){
		List<ProjPostTagDto> tagDto = session.selectList("projPostTag.getTags", dtoNum);
		return tagDto;
	}	
}
