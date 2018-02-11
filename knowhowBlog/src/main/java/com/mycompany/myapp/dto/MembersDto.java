package com.mycompany.myapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class MembersDto {
	
	private int mem_num; /* 회원 번호 */
				/* 아이디, 비밀번호, 이름, 프로필 사진 경로, 유저 정보 등록자, 등록 일시,      유저 정보 수정자,    수정 일시 */
	private String id, pwd, name, imagePath, user_regr_id, user_reg_dtime, user_modr_id, user_mod_dtime; 
	private MultipartFile uploadImage; /* 업로드 이미지 */
	private boolean isMember;/* 회원 여부  */
	
	public MembersDto() {}

	public MembersDto(int mem_num, String id, String pwd, String name, String imagePath, String user_regr_id,
			String user_reg_dtime, String user_modr_id, String user_mod_dtime, MultipartFile uploadImage,
			boolean isMember) {
		super();
		this.mem_num = mem_num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.imagePath = imagePath;
		this.user_regr_id = user_regr_id;
		this.user_reg_dtime = user_reg_dtime;
		this.user_modr_id = user_modr_id;
		this.user_mod_dtime = user_mod_dtime;
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

	public String getUser_regr_id() {
		return user_regr_id;
	}

	public void setUser_regr_id(String user_regr_id) {
		this.user_regr_id = user_regr_id;
	}

	public String getUser_reg_dtime() {
		return user_reg_dtime;
	}

	public void setUser_reg_dtime(String user_reg_dtime) {
		this.user_reg_dtime = user_reg_dtime;
	}

	public String getUser_modr_id() {
		return user_modr_id;
	}

	public void setUser_modr_id(String user_modr_id) {
		this.user_modr_id = user_modr_id;
	}

	public String getUser_mod_dtime() {
		return user_mod_dtime;
	}

	public void setUser_mod_dtime(String user_mod_dtime) {
		this.user_mod_dtime = user_mod_dtime;
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
