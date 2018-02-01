package com.mycompany.myapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProjTimelineDto {
	private int post_num, post_proj_num;
	private String post_title, post_content, post_filePath, post_regr_id, post_reg_dtime, post_modr_id, post_mod_dtime;
	private boolean disp_tf;
	private MultipartFile uploadImage;
	
	public ProjTimelineDto() {}

	public ProjTimelineDto(int post_num, int post_proj_num, String post_title, String post_content,
			String post_filePath, String post_regr_id, String post_reg_dtime, String post_modr_id,
			String post_mod_dtime, boolean disp_tf, MultipartFile uploadImage) {
		super();
		this.post_num = post_num;
		this.post_proj_num = post_proj_num;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_filePath = post_filePath;
		this.post_regr_id = post_regr_id;
		this.post_reg_dtime = post_reg_dtime;
		this.post_modr_id = post_modr_id;
		this.post_mod_dtime = post_mod_dtime;
		this.disp_tf = disp_tf;
		this.uploadImage = uploadImage;
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

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_filePath() {
		return post_filePath;
	}

	public void setPost_filePath(String post_filePath) {
		this.post_filePath = post_filePath;
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

	public boolean isDisp_tf() {
		return disp_tf;
	}

	public void setDisp_tf(boolean disp_tf) {
		this.disp_tf = disp_tf;
	}

	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}

	
}
