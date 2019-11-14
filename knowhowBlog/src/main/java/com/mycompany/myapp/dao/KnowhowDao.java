package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;


public interface KnowhowDao {
    
    public List<KnowhowDto> getList();                                   /* 리스트 가져오기 */
    public List<KnowhowDto> getSearchList(List<Integer> kh_nums);        /* 검색 리스트 */
    public int insert(KnowhowDto dto);                                   /* 노하우 등록 */
    public KnowhowDto getDetail(int kh_num);                                /* 노하우 상세보기 */
    public KnowhowDto getFile(int dtoNum);                               /* 파일 가져오기 */
    public List<KnowhowTagDto> getTags(int kh_num);                      /* 태그 가져오기 */
    public void update(KnowhowDto dto) ;                                 /* 노하우 수정 */
    public void delete(int kh_num);                                      /* 노하우 삭제 */
    public void cmtInsert(KnowhowCommentDto dto);                        /* 노하우 디테일 내 댓글 등록 */
    public List<KnowhowCommentDto> getCmts(int kh_num);                  /* 등록된 댓글 가져오기 */
    public List<KnowhowDto> getRecentList();                             /* 노하우 최근 리스트 가져오기 */
}
