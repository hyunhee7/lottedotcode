package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.ProjBoardDto;

@Repository
public class ProjBoardDaoImpl implements ProjBoardDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(ProjBoardDto dto) {
		session.insert("projBoard.insert", dto);
	}
	@Override
	public List<ProjBoardDto> getList() {
		List<ProjBoardDto> list=session.selectList("projBoard.getList");
		return list;
	}
	@Override
	public List<ProjBoardDto> getRecentList() {
		List<ProjBoardDto> list=session.selectList("projBoard.getRecentList");
		return list;
	}	
	@Override
	public ProjBoardDto getDetail(int proj_num) {
		ProjBoardDto dto = session.selectOne("projBoard.getDetail", proj_num);
		return dto;
	}
	@Override
	public void update(ProjBoardDto dto) {
		session.update("projBoard.update", dto);
	}
	@Override
	public void delete(int proj_num) {
		session.delete("projBoard.delete", proj_num);
	}	
}
