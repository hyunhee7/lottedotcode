package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.ProjTimelineDto;


public interface ProjTimelineDao {
	public List<ProjTimelineDto> getList(int num);
}
