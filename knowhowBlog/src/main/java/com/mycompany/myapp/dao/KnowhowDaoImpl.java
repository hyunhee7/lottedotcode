package com.mycompany.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowDto;

@Repository
public class KnowhowDaoImpl implements KnowhowDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(KnowhowDto dto) {
		session.insert("knowhow.insert", dto);
		int kh_num = dto.getKh_num();
		System.out.println("포스트넘:"+kh_num);
		return kh_num;
	}
	
}
