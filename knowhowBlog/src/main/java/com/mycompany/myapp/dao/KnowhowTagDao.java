package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.KnowhowTagDto;

public interface KnowhowTagDao {
    public void insert(KnowhowTagDto dto);                    /* 노하우 태그 등록 */
    public boolean findTag(KnowhowTagDto dto);                /* 노하우 게시물에 따라 태그 가져오기 */
    public List<Integer> findPost_num(String tag_name);        /* 노하우 수정시 태그 새로 등록해야하는지 여부 알아오기 */
}
