package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;


public interface ProjTimelineDao {
    public int insert(ProjTimelineDto dto);                               /* 포스트 등록하기 */
    public List<ProjTimelineDto> getList(int num);                        /* 포스트 리스트 가져오기 */
    public ProjTimelineDto getDetail(ProjTimelineDto dto);                /* 포스트 상세보기 */
    public List<ProjPostTagDto> getTags(ProjTimelineDto tagDto);          /* 등록된 태그 가져오기 */
    public ProjTimelineDto getFile(ProjTimelineDto dtoNum);               /* 포스트 내 파일 다운로드 경로 가져오기 */
    public void update(ProjTimelineDto dto);                              /* 포스트 수정하기 */
    public void delete(ProjTimelineDto dto);                              /* 포스트 삭제하기 */
    public void cmtInsert(ProjPostCommentDto dto);                        /* 댓글 등록하기 */
    public List<ProjPostCommentDto> getCmts(ProjTimelineDto dtoNum);      /* 포스트에 등록된 댓글 리스트 가져오기 */
}
