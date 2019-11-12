package com.mycompany.myapp.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.MembersDao;
import com.mycompany.myapp.dto.MembersDto;
/* 회원 Service */
@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao membersDao;
	
	/* 회원가입 */
	@Override
	public MembersDto signup(MembersDto dto) {
		dto.setUser_regr_id(dto.getId());
		dto.setUser_modr_id(dto.getId());
        //FileDao 객체를 이용해서 DB 에 저장하기
		membersDao.insert(dto);
		return dto;
	}

	/* ID 사용가능 여부 */
	@Override
	public boolean canUseId(String id) {
		//사용가능한 아이디 인지 여부를 리턴받아서 
		boolean canUse=membersDao.canUseId(id);
		//리턴해준다. 
		return canUse;		
	}	
	
	/* 로그인 */
	@Override
	public boolean signin(MembersDto dto) {
		boolean isValid=membersDao.isValid(dto);
		return isValid;
	}	
	
	/* 프로필 사진 가져오기 */
	@Override
	public String getPath(String id) {
		String imgPath = membersDao.getPath(id);
		if(imgPath.isEmpty()) {
			imgPath="logo.png";
		}
		return imgPath;
	}	
}
