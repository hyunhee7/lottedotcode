package com.mycompany.myapp.dto;

public class KnowhowTagDto {
	private int tag_num, tag_kh_num;
	private String tag_name;
	
	public KnowhowTagDto() {}

	public KnowhowTagDto(int tag_num, int tag_kh_num, String tag_name) {
		super();
		this.tag_num = tag_num;
		this.tag_kh_num = tag_kh_num;
		this.tag_name = tag_name;
	}

	public int getTag_num() {
		return tag_num;
	}

	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}

	public int getTag_kh_num() {
		return tag_kh_num;
	}

	public void setTag_kh_num(int tag_kh_num) {
		this.tag_kh_num = tag_kh_num;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}



	
}
