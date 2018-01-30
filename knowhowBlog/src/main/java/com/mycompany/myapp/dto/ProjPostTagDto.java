package com.mycompany.myapp.dto;

public class ProjPostTagDto {
	private int tag_num, tag_post_num;
	private String tag_name;
	
	public ProjPostTagDto() {}

	public ProjPostTagDto(int tag_num, int tag_post_num, String tag_name) {
		super();
		this.tag_num = tag_num;
		this.tag_post_num = tag_post_num;
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

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	
	
}
