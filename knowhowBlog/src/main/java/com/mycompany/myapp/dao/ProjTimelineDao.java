package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;


public interface ProjTimelineDao {
	public int insert(ProjTimelineDto dto);
	public List<ProjTimelineDto> getList(int num);
	public ProjTimelineDto getDetail(ProjTimelineDto dto);
	public List<ProjPostTagDto> getTags(ProjTimelineDto tagDto);
	public ProjTimelineDto getFile(ProjTimelineDto dtoNum);
}
