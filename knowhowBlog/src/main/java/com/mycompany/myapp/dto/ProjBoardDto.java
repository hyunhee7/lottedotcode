package com.mycompany.myapp.dto;

import org.springframework.web.multipart.MultipartFile;
/* 프로젝트 보드 Dto */
public class ProjBoardDto {
    
    private int proj_num; /* 프로젝트 번호  */
    
                /* 프로젝트 제목,  프로젝트 내용,     프로젝트 이미지 경로, 프로젝트 등록자,   프로젝트 등록 일시,   프로젝트 수정자,  프로젝트 수정 일시*/
    private String proj_title, proj_content, proj_imagePath, proj_regr_id, proj_reg_dtime, proj_modr_id, proj_mod_dtime;
    private boolean proj_disp_tf; /* 프로젝트 게시 여부 */
    private MultipartFile uploadImage; /* 업로드 이미지 */
    
    public ProjBoardDto() {}

    public ProjBoardDto(int proj_num, String proj_title, String proj_content, String proj_imagePath,
            String proj_regr_id, String proj_reg_dtime, String proj_modr_id, String proj_mod_dtime,
            boolean proj_disp_tf, MultipartFile uploadImage) {
        super();
        this.proj_num = proj_num;
        this.proj_title = proj_title;
        this.proj_content = proj_content;
        this.proj_imagePath = proj_imagePath;
        this.proj_regr_id = proj_regr_id;
        this.proj_reg_dtime = proj_reg_dtime;
        this.proj_modr_id = proj_modr_id;
        this.proj_mod_dtime = proj_mod_dtime;
        this.proj_disp_tf = proj_disp_tf;
        this.uploadImage = uploadImage;
    }

    public int getProj_num() {
        return proj_num;
    }

    public void setProj_num(int proj_num) {
        this.proj_num = proj_num;
    }

    public String getProj_title() {
        return proj_title;
    }

    public void setProj_title(String proj_title) {
        this.proj_title = proj_title;
    }

    public String getProj_content() {
        return proj_content;
    }

    public void setProj_content(String proj_content) {
        this.proj_content = proj_content;
    }

    public String getProj_imagePath() {
        return proj_imagePath;
    }

    public void setProj_imagePath(String proj_imagePath) {
        this.proj_imagePath = proj_imagePath;
    }

    public String getProj_regr_id() {
        return proj_regr_id;
    }

    public void setProj_regr_id(String proj_regr_id) {
        this.proj_regr_id = proj_regr_id;
    }

    public String getProj_reg_dtime() {
        return proj_reg_dtime;
    }

    public void setProj_reg_dtime(String proj_reg_dtime) {
        this.proj_reg_dtime = proj_reg_dtime;
    }

    public String getProj_modr_id() {
        return proj_modr_id;
    }

    public void setProj_modr_id(String proj_modr_id) {
        this.proj_modr_id = proj_modr_id;
    }

    public String getProj_mod_dtime() {
        return proj_mod_dtime;
    }

    public void setProj_mod_dtime(String proj_mod_dtime) {
        this.proj_mod_dtime = proj_mod_dtime;
    }

    public boolean isProj_disp_tf() {
        return proj_disp_tf;
    }

    public void setProj_disp_tf(boolean proj_disp_tf) {
        this.proj_disp_tf = proj_disp_tf;
    }

    public MultipartFile getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(MultipartFile uploadImage) {
        this.uploadImage = uploadImage;
    }


}
