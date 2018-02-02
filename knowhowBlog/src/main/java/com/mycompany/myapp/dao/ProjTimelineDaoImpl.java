package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public void insert(ProjTimelineDto dto) {
		session.insert("projTimeline.insert", dto);
	}
}
