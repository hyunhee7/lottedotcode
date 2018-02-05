package com.mycompany.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowTagDto;



@Repository
public class KnowhowTagDaoImpl implements KnowhowTagDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(KnowhowTagDto dto) {
		session.insert("knowhowTag.insert", dto);
	}
	
}
