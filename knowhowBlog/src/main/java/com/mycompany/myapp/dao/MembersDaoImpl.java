package com.mycompany.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.MembersDto;

@Repository
public class MembersDaoImpl implements MembersDao {

    @Autowired
    private SqlSession session;
    
    /* 회원 가입 */
    @Override
    public void insert(MembersDto dto) {
        session.insert("members.insert", dto);
    }
    
    /* 아이디 중복 확인 */
    @Override
    public boolean canUseId(String id) {
        String result=session.selectOne("members.isExistId", id);
        if(result==null){
            return true;
        }else{
            return false;
        }
    }
    
    /* 로그인 가능 여부 */
    @Override
    public boolean isValid(MembersDto dto) {
        MembersDto resultDto=session.selectOne("members.isValid", dto);
        /* 아이디 및 비밀번호가 안맞을 경우 null을 return한다. */
        if(resultDto==null){
            return false;
        }else{
            return true;
        }
    }    
    
    /* 회원 이미지 경로 가져오기 */
    @Override
    public String getPath(String id) {
        String imgPath = session.selectOne("members.getPath", id);
        return imgPath;
    }
    
}
