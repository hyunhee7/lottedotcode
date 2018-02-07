package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.ProjBoardDto;

public interface ProjBoardDao {
	public void insert(ProjBoardDto dto);
	public List<ProjBoardDto> getList();
	public List<ProjBoardDto> getRecentList();
	public ProjBoardDto getDetail(int proj_num);
	public void update(ProjBoardDto dto);
}
