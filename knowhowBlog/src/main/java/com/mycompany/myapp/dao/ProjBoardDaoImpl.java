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
	
	/* 프로젝트 등록하기 */
	@Override
	public void insert(ProjBoardDto dto) {
		session.insert("projBoard.insert", dto);
	}
	
	/* 프로젝트 리스트 불러오기 */
	@Override
	public List<ProjBoardDto> getList() {
		List<ProjBoardDto> list=session.selectList("projBoard.getList");
		return list;
	}
	
	/* 최근 프로젝트 가져오기 */
	@Override
	public List<ProjBoardDto> getRecentList() {
		List<ProjBoardDto> list=session.selectList("projBoard.getRecentList");
		return list;
	}	
	
	/* 프로젝트 정보 가져오기 */
	@Override
	public ProjBoardDto getDetail(int proj_num) {
		ProjBoardDto dto = session.selectOne("projBoard.getDetail", proj_num);
		return dto;
	}
	
	/* 프로젝트 수정하기 */
	@Override
	public void update(ProjBoardDto dto) {
		session.update("projBoard.update", dto);
	}
	
	/* 프로젝트 삭제하기 */
	@Override
	public void delete(int proj_num) {
		session.delete("projBoard.delete", proj_num);
	}	
}
