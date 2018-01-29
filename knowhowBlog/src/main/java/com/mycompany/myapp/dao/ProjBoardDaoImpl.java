package com.mycompany.myapp.dao;

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

}
