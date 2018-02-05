package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;

@Repository
public class KnowhowDaoImpl implements KnowhowDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<KnowhowDto> getList(){
		List<KnowhowDto> list = session.selectList("knowhow.getList");
		return list;
	}
	
	@Override
	public int insert(KnowhowDto dto) {
		session.insert("knowhow.insert", dto);
		int kh_num = dto.getKh_num();
		System.out.println("포스트넘:"+kh_num);
		return kh_num;
	}
	
	@Override
	public KnowhowDto getDetail(KnowhowDto dtoNum){
		KnowhowDto dto = session.selectOne("knowhow.getDetail", dtoNum);
		return dto;
	}
	
	@Override
	public KnowhowDto getFile(KnowhowDto dtoNum){
		System.out.println("여긴 나오냐:"+dtoNum.getKh_num());
		KnowhowDto dto = session.selectOne("knowhow.getFile", dtoNum);
		System.out.println("나와라:"+dto.getKh_fileOrgName());
		return dto;
	}
	
	@Override
	public List<KnowhowTagDto> getTags(KnowhowDto dtoNum){
		List<KnowhowTagDto> tagDto = session.selectList("knowhowTag.getTags", dtoNum);
		return tagDto;
	}		

	@Override
	public void update(KnowhowDto dto) {
		session.insert("knowhow.update", dto);
	}
	
	@Override
	public void delete(int kh_num) {
		session.delete("knowhow.delete", kh_num);
	}
	
}
