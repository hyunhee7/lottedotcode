package com.mycompany.myapp.dto;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class ProjTimelineDto {
	private int post_num, post_proj_num;
	private String post_title, post_filePath, post_content, post_regr_id, post_reg_dtime, post_modr_id, post_mod_dtime;
	private boolean post_disp_tf;
	private MultipartFile uploadImage;
	private List<ProjPostTagDto> post_tag;
	private String[] tags;
	private int tmpPostNum;
	private int lastPostNum;
	private String post_fileOrgName;
	private long post_fileSize;	
	
	public ProjTimelineDto() {}

	public ProjTimelineDto(int post_num, int post_proj_num, String post_title, String post_filePath,
			String post_content, String post_regr_id, String post_reg_dtime, String post_modr_id, String post_mod_dtime,
			boolean post_disp_tf, MultipartFile uploadImage, List<ProjPostTagDto> post_tag, String[] tags,
			int tmpPostNum, int lastPostNum, String post_fileOrgName, long post_fileSize) {
		super();
		this.post_num = post_num;
		this.post_proj_num = post_proj_num;
		this.post_title = post_title;
		this.post_filePath = post_filePath;
		this.post_content = post_content;
		this.post_regr_id = post_regr_id;
		this.post_reg_dtime = post_reg_dtime;
		this.post_modr_id = post_modr_id;
		this.post_mod_dtime = post_mod_dtime;
		this.post_disp_tf = post_disp_tf;
		this.uploadImage = uploadImage;
		this.post_tag = post_tag;
		this.tags = tags;
		this.tmpPostNum = tmpPostNum;
		this.lastPostNum = lastPostNum;
		this.post_fileOrgName = post_fileOrgName;
		this.post_fileSize = post_fileSize;
	}

	public int getPost_num() {
		return post_num;
	}

	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}

	public int getPost_proj_num() {
		return post_proj_num;
	}

	public void setPost_proj_num(int post_proj_num) {
		this.post_proj_num = post_proj_num;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_filePath() {
		return post_filePath;
	}

	public void setPost_filePath(String post_filePath) {
		this.post_filePath = post_filePath;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_regr_id() {
		return post_regr_id;
	}

	public void setPost_regr_id(String post_regr_id) {
		this.post_regr_id = post_regr_id;
	}

	public String getPost_reg_dtime() {
		return post_reg_dtime;
	}

	public void setPost_reg_dtime(String post_reg_dtime) {
		this.post_reg_dtime = post_reg_dtime;
	}

	public String getPost_modr_id() {
		return post_modr_id;
	}

	public void setPost_modr_id(String post_modr_id) {
		this.post_modr_id = post_modr_id;
	}

	public String getPost_mod_dtime() {
		return post_mod_dtime;
	}

	public void setPost_mod_dtime(String post_mod_dtime) {
		this.post_mod_dtime = post_mod_dtime;
	}

	public boolean isPost_disp_tf() {
		return post_disp_tf;
	}

	public void setPost_disp_tf(boolean post_disp_tf) {
		this.post_disp_tf = post_disp_tf;
	}

	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}

	public List<ProjPostTagDto> getPost_tag() {
		return post_tag;
	}

	public void setPost_tag(List<ProjPostTagDto> post_tag) {
		this.post_tag = post_tag;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public int getTmpPostNum() {
		return tmpPostNum;
	}

	public void setTmpPostNum(int tmpPostNum) {
		this.tmpPostNum = tmpPostNum;
	}

	public int getLastPostNum() {
		return lastPostNum;
	}

	public void setLastPostNum(int lastPostNum) {
		this.lastPostNum = lastPostNum;
	}

	public String getPost_fileOrgName() {
		return post_fileOrgName;
	}

	public void setPost_fileOrgName(String post_fileOrgName) {
		this.post_fileOrgName = post_fileOrgName;
	}

	public long getPost_fileSize() {
		return post_fileSize;
	}

	public void setPost_fileSize(long post_fileSize) {
		this.post_fileSize = post_fileSize;
	}

	

}
