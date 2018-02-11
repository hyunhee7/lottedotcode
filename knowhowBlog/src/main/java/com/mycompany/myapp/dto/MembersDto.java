package com.mycompany.myapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class MembersDto {
	
	private int mem_num; /* 회원 번호 */
	private String id, pwd, name, imagePath; /* 회원 id, 비밀번호, 이름, 프로필 사진 경로 */
	private MultipartFile uploadImage; /* 업로드 이미지 */
	private boolean isMember;/* 회원 여부  */
	
	public MembersDto() {}

	public MembersDto(int mem_num, String id, String pwd, String name, String imagePath, MultipartFile uploadImage,
			boolean isMember) {
		super();
		this.mem_num = mem_num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.imagePath = imagePath;
		this.uploadImage = uploadImage;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	
}
