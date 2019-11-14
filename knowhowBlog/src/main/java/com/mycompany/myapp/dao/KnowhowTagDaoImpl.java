package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowTagDto;



@Repository
public class KnowhowTagDaoImpl implements KnowhowTagDao {
    
    @Autowired
    private SqlSession session;
    
    /* 노하우 태그 등록 */
    @Override
    public void insert(KnowhowTagDto dto) {
        session.insert("knowhowTag.insert", dto);
    }
    
    /* 노하우 수정시 태그 새로 등록해야하는지 여부 알아오기 */
    @Override
    public boolean findTag(KnowhowTagDto dto) {
        System.out.println("노하우태그find전"+dto.getTag_name());
        int cnt=session.selectOne("knowhowTag.findTag", dto);
        if(cnt==0) {
            return false;
        }else
            return true;
    }    
    
    /* 태그 검색 시 노하우 번호 보내주기 */
    @Override
    public List<Integer> findPost_num(String tag_name){
        List<Integer> kh_num = session.selectList("knowhowTag.findKh_num", tag_name);
        System.out.println("findPost_num:"+kh_num.get(0));
        return kh_num;
    }
}
