package com.mycompany.myapp.dto;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


public class KnowhowDto {
	private int kh_num;
	private String kh_title, kh_filePath, kh_content, kh_regr_id, kh_reg_dtime, kh_modr_id, kh_mod_dtime;
	private boolean kh_disp_tf;
	private MultipartFile uploadImage;
	private List<KnowhowTagDto> post_tag;
	private String[] tags;
	private String kh_fileOrgName;
	private long kh_fileSize;	
	
	public KnowhowDto() {}

	public KnowhowDto(int kh_num, String kh_title, String kh_filePath, String kh_content, String kh_regr_id,
			String kh_reg_dtime, String kh_modr_id, String kh_mod_dtime, boolean kh_disp_tf, MultipartFile uploadImage,
			List<KnowhowTagDto> post_tag, String[] tags, String kh_fileOrgName, long kh_fileSize) {
		super();
		this.kh_num = kh_num;
		this.kh_title = kh_title;
		this.kh_filePath = kh_filePath;
		this.kh_content = kh_content;
		this.kh_regr_id = kh_regr_id;
		this.kh_reg_dtime = kh_reg_dtime;
		this.kh_modr_id = kh_modr_id;
		this.kh_mod_dtime = kh_mod_dtime;
		this.kh_disp_tf = kh_disp_tf;
		this.uploadImage = uploadImage;
		this.post_tag = post_tag;
		this.tags = tags;
		this.kh_fileOrgName = kh_fileOrgName;
		this.kh_fileSize = kh_fileSize;
	}

	public int getKh_num() {
		return kh_num;
	}

	public void setKh_num(int kh_num) {
		this.kh_num = kh_num;
	}

	public String getKh_title() {
		return kh_title;
	}

	public void setKh_title(String kh_title) {
		this.kh_title = kh_title;
	}

	public String getKh_filePath() {
		return kh_filePath;
	}

	public void setKh_filePath(String kh_filePath) {
		this.kh_filePath = kh_filePath;
	}

	public String getKh_content() {
		return kh_content;
	}

	public void setKh_content(String kh_content) {
		this.kh_content = kh_content;
	}

	public String getKh_regr_id() {
		return kh_regr_id;
	}

	public void setKh_regr_id(String kh_regr_id) {
		this.kh_regr_id = kh_regr_id;
	}

	public String getKh_reg_dtime() {
		return kh_reg_dtime;
	}

	public void setKh_reg_dtime(String kh_reg_dtime) {
		this.kh_reg_dtime = kh_reg_dtime;
	}

	public String getKh_modr_id() {
		return kh_modr_id;
	}

	public void setKh_modr_id(String kh_modr_id) {
		this.kh_modr_id = kh_modr_id;
	}

	public String getKh_mod_dtime() {
		return kh_mod_dtime;
	}

	public void setKh_mod_dtime(String kh_mod_dtime) {
		this.kh_mod_dtime = kh_mod_dtime;
	}

	public boolean isKh_disp_tf() {
		return kh_disp_tf;
	}

	public void setKh_disp_tf(boolean kh_disp_tf) {
		this.kh_disp_tf = kh_disp_tf;
	}

	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}

	public List<KnowhowTagDto> getPost_tag() {
		return post_tag;
	}

	public void setPost_tag(List<KnowhowTagDto> post_tag) {
		this.post_tag = post_tag;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getKh_fileOrgName() {
		return kh_fileOrgName;
	}

	public void setKh_fileOrgName(String kh_fileOrgName) {
		this.kh_fileOrgName = kh_fileOrgName;
	}

	public long getKh_fileSize() {
		return kh_fileSize;
	}

	public void setKh_fileSize(long kh_fileSize) {
		this.kh_fileSize = kh_fileSize;
	}



}
