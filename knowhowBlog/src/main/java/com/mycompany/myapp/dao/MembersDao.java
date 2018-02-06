package com.mycompany.myapp.dao;

import com.mycompany.myapp.dto.MembersDto;

public interface MembersDao {
	public void insert(MembersDto dto);
	public boolean canUseId(String id);
	public boolean isValid(MembersDto dto);
	public String getPath(String id);
}
