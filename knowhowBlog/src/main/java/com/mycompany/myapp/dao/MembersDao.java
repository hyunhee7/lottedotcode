package com.mycompany.myapp.dao;

import com.mycompany.myapp.dto.MembersDto;

public interface MembersDao {
    public void insert(MembersDto dto);                    /* 회원 등록 */
    public boolean canUseId(String id);                    /* 아이디 사용 가능 여부 */
    public boolean isValid(MembersDto dto);                /* 로그인 가능 여부 */
    public String getPath(String id);                      /* 회원 사진 경로 가져오기 */
}
