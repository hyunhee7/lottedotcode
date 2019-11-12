package com.mycompany.myapp.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.KnowhowDao;
import com.mycompany.myapp.dao.KnowhowTagDao;
import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.KnowhowTagDto;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostTagDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
/* 노하우 Service */
@Service
public class KnowhowServiceImpl implements KnowhowService {

	@Autowired
	private KnowhowDao knowhowDao;
	
	@Autowired
	private KnowhowTagDao knowhowTagDao;
	
	/* 노하우 리스트 */
	@Override
	public List<KnowhowDto> list() {
		List<KnowhowDto> list = knowhowDao.getList();
		return list;
	}	

	/* 노하우 태그별 검색 */
	@Override
	public List<KnowhowDto> Searchlist(String tag_name) {
		List<Integer> kh_nums = knowhowTagDao.findPost_num(tag_name);
		List<KnowhowDto> list = knowhowDao.getSearchList(kh_nums);
		return list;
	}	
		
	/* 노하우 등록 */
	@Override
	public int insert(KnowhowDto dto) {
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
		int kh_num=knowhowDao.insert(dto);
		return kh_num;
	}

	/* 노하우 상세보기 */
	@Override
	public KnowhowDto detail(KnowhowDto dtoNum) {
		KnowhowDto dto = knowhowDao.getDetail(dtoNum);
		/* 노하우 태그 리스트 가져오기 */
		List<KnowhowTagDto> tags = knowhowDao.getTags(dtoNum);
		dto.setPost_tag(tags);
		/* 노하우 댓글 리스트 가져오기 */
		List<KnowhowCommentDto> cmts = knowhowDao.getCmts(dtoNum);
		dto.setCmts(cmts);
		return dto;
	}	

	/* 파일 다운로드 준비 */
	@Override
	public KnowhowDto getFile(KnowhowDto dtoNum) {
		//다운로드 시켜줄 파일의 정보를 DB 에서 얻어오고
		KnowhowDto dto=knowhowDao.getFile(dtoNum);
		System.out.println(dto.getKh_fileOrgName());
		//리턴해준다.
		return dto;
	}
	
	/* 노하우 수정 */
	@Override
	public void update(KnowhowDto dto) {
        knowhowDao.update(dto);
	}	
	
	/* 노하우 삭제 */
	@Override
	public void delete(int kh_num) {
		knowhowDao.delete(kh_num);
	}	
	
	/* 댓글 등록 */
	@Override
	public void cmtInsert(KnowhowCommentDto dto) {
		knowhowDao.cmtInsert(dto);
	}
	
	/* 최근 노하우 리스트 */
	@Override
	public List<KnowhowDto> recentList() {
		List<KnowhowDto> list=knowhowDao.getRecentList();
		return list;
	}		

}
