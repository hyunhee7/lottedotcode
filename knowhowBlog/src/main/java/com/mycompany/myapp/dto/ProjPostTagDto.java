package com.mycompany.myapp.dto;
/* 포스트 태그 Dto */
public class ProjPostTagDto {
			/*  태그 번호,  태그 포스트 번호,   태그 프로젝트 번호  */
	private int tag_num, tag_post_num, tag_proj_num;
	private String tag_name; /* 태그 명 */
	
	public ProjPostTagDto() {}

	public ProjPostTagDto(int tag_num, int tag_post_num, int tag_proj_num, String tag_name) {
		super();
		this.tag_num = tag_num;
		this.tag_post_num = tag_post_num;
		this.tag_proj_num = tag_proj_num;
		this.tag_name = tag_name;
	}

	public int getTag_num() {
		return tag_num;
	}

	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}

	public int getTag_post_num() {
		return tag_post_num;
	}

	public void setTag_post_num(int tag_post_num) {
		this.tag_post_num = tag_post_num;
	}

	public int getTag_proj_num() {
		return tag_proj_num;
	}

	public void setTag_proj_num(int tag_proj_num) {
		this.tag_proj_num = tag_proj_num;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	
}
