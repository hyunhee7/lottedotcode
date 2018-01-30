package com.mycompany.myapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProjTimelineDto {
	private int post_num, post_proj_num;
	private String post_title, post_writer, post_content, post_date, post_filePath;
	private boolean disp_tf;
	private MultipartFile uploadImage;
	
	public ProjTimelineDto() {}

	public ProjTimelineDto(int post_num, int post_proj_num, String post_title, String post_writer, String post_content,
			String post_date, String post_filePath, boolean disp_tf, MultipartFile uploadImage) {
		super();
		this.post_num = post_num;
		this.post_proj_num = post_proj_num;
		this.post_title = post_title;
		this.post_writer = post_writer;
		this.post_content = post_content;
		this.post_date = post_date;
		this.post_filePath = post_filePath;
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

	public String getPost_writer() {
		return post_writer;
	}

	public void setPost_writer(String post_writer) {
		this.post_writer = post_writer;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public String getPost_filePath() {
		return post_filePath;
	}

	public void setPost_filePath(String post_filePath) {
		this.post_filePath = post_filePath;
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
