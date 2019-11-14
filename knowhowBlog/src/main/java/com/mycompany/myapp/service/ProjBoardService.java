package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.ProjBoardDto;
/* 프로젝트 보드 Service */
public interface ProjBoardService {    
    public void insert(ProjBoardDto dto, String realPath);                   /* 프로젝트 등록 */
    public List<ProjBoardDto> list();                                        /* 프로젝트 리스트 */
    public List<ProjBoardDto> recentList();                                  /* 최근 프로젝트 리스트 */
    public ProjBoardDto detail(int num);                                     /* 프로젝트 상세보기 */
    public void update(ProjBoardDto dto, String realPath);                   /* 프로젝트 수정 */
    public void delete(int proj_num);                                        /* 프로젝트 삭제 */
}
