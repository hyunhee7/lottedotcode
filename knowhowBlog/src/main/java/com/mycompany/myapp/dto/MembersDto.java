package com.mycompany.myapp.dto;

public class MembersDto {
	
	private int mem_num;
	private String id, pwd, name, image;
	private boolean isMember;
	
	public MembersDto(int mem_num, String id, String pwd, String name, String image, boolean isMember) {
		super();
		this.mem_num = mem_num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.image = image;
		this.isMember = isMember;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	
	
	
}
