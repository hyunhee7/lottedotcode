package com.mycompany.myapp.dto;
/* 포스트 댓글 Dto */
public class ProjPostCommentDto {
	/*  댓글 번호,  댓글 포스트 번호 ,  댓글 프로젝트 번호 */
	int cmt_num, cmt_post_num, cmt_proj_num;
	/* 	   댓글 작성자, 작성자 프로필 사진, 작성 내용,		 댓글 등록 id,    댓글 등록 날짜, 	 댓글 수정 id,	  댓글 수정 날짜 */
	String cmt_id, cmt_imgPath, cmt_content, cmt_regr_id, cmt_reg_dtime, cmt_modr_id, cmt_mod_dtime;
	
	
	public ProjPostCommentDto() {}

	
	public ProjPostCommentDto(int cmt_num, int cmt_post_num, int cmt_proj_num, String cmt_id, String cmt_imgPath,
			String cmt_content, String cmt_regr_id, String cmt_reg_dtime, String cmt_modr_id, String cmt_mod_dtime) {
		super();
		this.cmt_num = cmt_num;
		this.cmt_post_num = cmt_post_num;
		this.cmt_proj_num = cmt_proj_num;
		this.cmt_id = cmt_id;
		this.cmt_imgPath = cmt_imgPath;
		this.cmt_content = cmt_content;
		this.cmt_regr_id = cmt_regr_id;
		this.cmt_reg_dtime = cmt_reg_dtime;
		this.cmt_modr_id = cmt_modr_id;
		this.cmt_mod_dtime = cmt_mod_dtime;
	}


	public int getCmt_num() {
		return cmt_num;
	}


	public void setCmt_num(int cmt_num) {
		this.cmt_num = cmt_num;
	}


	public int getCmt_post_num() {
		return cmt_post_num;
	}


	public void setCmt_post_num(int cmt_post_num) {
		this.cmt_post_num = cmt_post_num;
	}


	public int getCmt_proj_num() {
		return cmt_proj_num;
	}


	public void setCmt_proj_num(int cmt_proj_num) {
		this.cmt_proj_num = cmt_proj_num;
	}


	public String getCmt_id() {
		return cmt_id;
	}


	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}


	public String getCmt_imgPath() {
		return cmt_imgPath;
	}


	public void setCmt_imgPath(String cmt_imgPath) {
		this.cmt_imgPath = cmt_imgPath;
	}


	public String getCmt_content() {
		return cmt_content;
	}


	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}


	public String getCmt_regr_id() {
		return cmt_regr_id;
	}


	public void setCmt_regr_id(String cmt_regr_id) {
		this.cmt_regr_id = cmt_regr_id;
	}


	public String getCmt_reg_dtime() {
		return cmt_reg_dtime;
	}


	public void setCmt_reg_dtime(String cmt_reg_dtime) {
		this.cmt_reg_dtime = cmt_reg_dtime;
	}


	public String getCmt_modr_id() {
		return cmt_modr_id;
	}


	public void setCmt_modr_id(String cmt_modr_id) {
		this.cmt_modr_id = cmt_modr_id;
	}


	public String getCmt_mod_dtime() {
		return cmt_mod_dtime;
	}


	public void setCmt_mod_dtime(String cmt_mod_dtime) {
		this.cmt_mod_dtime = cmt_mod_dtime;
	}


	
}
