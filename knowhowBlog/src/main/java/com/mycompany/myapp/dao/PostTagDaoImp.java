package com.mycompany.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjPostTagDto;



@Repository
public class PostTagDaoImp implements PostTagDao {

    @Autowired
    private SqlSession session;
    
    /* 태그 등록하기 */
    @Override
    public void insert(ProjPostTagDto dto) {
        session.insert("projPostTag.insert", dto);
    }
    
    /* 등록된 태그인지 알아보기 */
    @Override
    public boolean findTag(ProjPostTagDto dto) {
        int cnt=session.selectOne("projPostTag.findTag", dto);
        /* 1. count함수 이용
         * 2. 태그가 등록되지 않으면 false return
         * 3. 태그가 등록되었으면 true return  */
        if(cnt==0) {
            return false;
        }else
            return true;
    }
}
