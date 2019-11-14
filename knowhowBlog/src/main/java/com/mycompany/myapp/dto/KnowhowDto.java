package com.mycompany.myapp.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/* 노하우 보드 Dto */
public class KnowhowDto {
    private int kh_num; /* 노하우 번호 */
    
                /* 노하우 제목,  노하우 파일 경로, 노하우 내용,    노하우 등록 id, 노하우 등록 날짜,  노하우 수정 id, 노하우 수정 날짜   */
    private String kh_title, kh_filePath, kh_content, kh_regr_id, kh_reg_dtime, kh_modr_id, kh_mod_dtime;
    private boolean kh_disp_tf; /* 노하우 게시 여부 */
    private MultipartFile uploadImage; /* 업로드 파일 */
    private List<KnowhowTagDto> post_tag; /* 해당 노하우의 태그 list - detail에 가져올 때 */
    private String[] tags; /* 태그 list - 태그 insert 시 이용  */
    private String kh_fileOrgName; /* 원본 파일 명 */
    private long kh_fileSize;    /* 파일 크기 */
    private List<KnowhowCommentDto> cmts; /* 해당 노하우의 댓글 리스트 */
    
    /* 생성자 */
    public KnowhowDto() {}
    
    public KnowhowDto(int kh_num, String kh_title, String kh_filePath, String kh_content, String kh_regr_id,
            String kh_reg_dtime, String kh_modr_id, String kh_mod_dtime, boolean kh_disp_tf, MultipartFile uploadImage,
            List<KnowhowTagDto> post_tag, String[] tags, String kh_fileOrgName, long kh_fileSize,
            List<KnowhowCommentDto> cmts) {
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
        this.cmts = cmts;
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
    public List<KnowhowCommentDto> getCmts() {
        return cmts;
    }
    public void setCmts(List<KnowhowCommentDto> cmts) {
        this.cmts = cmts;
    }



}
