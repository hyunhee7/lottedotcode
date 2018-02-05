package com.mycompany.myapp.service;

import javax.servlet.http.HttpServletRequest;

import com.mycompany.myapp.dto.KnowhowDto;

public interface KnowhowService {
	public int insert(KnowhowDto dto,HttpServletRequest request);
}
