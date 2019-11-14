package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.ProjBoardDto;

public interface ProjBoardDao {
    public void insert(ProjBoardDto dto);                /* 프로젝트 등록  */
    public List<ProjBoardDto> getList();                /* 프로젝트 리스트 가져오기 */
    public List<ProjBoardDto> getRecentList();            /* 최근 등록된 프로젝트 가져오기 */
    public ProjBoardDto getDetail(int proj_num);        /* 프로젝트 내용 가져오기 */
    public void update(ProjBoardDto dto);                /* 프로젝트 수정하기 */
    public void delete(int proj_num);                    /* 프로젝트 삭제하기 */
}
