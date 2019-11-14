package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;

@Repository
public class KnowhowDaoImpl implements KnowhowDao {
    
    /* 세션 의존성 주입 */
    @Autowired
    private SqlSession session;

    /* 노하우 리스트 가져오기 */
    @Override
    public List<KnowhowDto> getList(){
        List<KnowhowDto> list = session.selectList("knowhow.getList");
        return list;
    }

    /* 노하우 검색 리스트 가져오기 */
    @Override
    public List<KnowhowDto> getSearchList(List<Integer> kh_nums){
        List<KnowhowDto> list = session.selectList("knowhow.getSearchList", kh_nums);
        return list;
    }    
    
    /* 노하우 등록 */
    @Override
    public int insert(KnowhowDto dto) {
        session.insert("knowhow.insert", dto);
        int kh_num = dto.getKh_num();
        return kh_num;
    }
    
    /* 노하우 상세보기  */
    @Override
    public KnowhowDto getDetail(int num){
        KnowhowDto dto = session.selectOne("knowhow.getDetail", num);
        return dto;
    }
    
    /* 노하우 파일 다운로드 */
    @Override
    public KnowhowDto getFile(int kh_num){
        KnowhowDto dto = session.selectOne("knowhow.getFile", kh_num);
        return dto;
    }
    
    /* 태그 가져오기 */
    @Override
    public List<KnowhowTagDto> getTags(int kh_num){
        List<KnowhowTagDto> tagDto = session.selectList("knowhowTag.getTags", kh_num);
        return tagDto;
    }        

    /* 노하우 수정하기 */
    @Override
    public void update(KnowhowDto dto) {
        session.insert("knowhow.update", dto);
    }
    
    /* 노하우 삭제하기 */
    @Override
    public void delete(int kh_num) {
        session.delete("knowhow.delete", kh_num);
    }
    
    /* 노하우 댓글 작성 */
    @Override
    public void cmtInsert(KnowhowCommentDto dto) {
        session.insert("knowhow.cmtinsert", dto);
    }
    
    /* 노하우 댓글 리스트 가져오기 */
    @Override
    public List<KnowhowCommentDto> getCmts(int kh_num){
        List<KnowhowCommentDto> cmtDto = session.selectList("knowhow.getCmts", kh_num);
        return cmtDto;
    }
    
    /* 노하우 최근 게시글 가져오기 */
    @Override
    public List<KnowhowDto> getRecentList() {
        List<KnowhowDto> list=session.selectList("knowhow.getRecentList");
        return list;
    }        
    
}
