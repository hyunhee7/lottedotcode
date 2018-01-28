package com.mycompany.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.MembersDto;

@Repository
public class MembersDaoImpl implements MembersDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MembersDto dto) {
		System.out.println("들어옴3");
		session.insert("members.insert", dto);
	}
	
	@Override
	public boolean canUseId(String id) {
		String result=session.selectOne("members.isExistId", id);
		if(result==null){
			return true;
		}else{
			return false;
		}
	}
	
}
