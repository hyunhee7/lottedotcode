package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.KnowhowTagDto;

public interface KnowhowTagDao {
	public void insert(KnowhowTagDto dto);
	public boolean findTag(KnowhowTagDto dto);
	public List<Integer> findPost_num(String tag_name);
}
