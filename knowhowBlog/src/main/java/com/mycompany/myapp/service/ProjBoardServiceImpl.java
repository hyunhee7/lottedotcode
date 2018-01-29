package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dto.ProjBoardDto;

@Service
public class ProjBoardServiceImpl implements ProjBoardService {

	@Autowired
	private ProjBoardDao projboardDao;
	
	@Override
	public void insert(ProjBoardDto dto) {
		projboardDao.insert(dto);
	}

}
