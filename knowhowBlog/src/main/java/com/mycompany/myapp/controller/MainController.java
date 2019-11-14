package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
import com.mycompany.myapp.service.KnowhowService;
import com.mycompany.myapp.service.MembersService;
import com.mycompany.myapp.service.ProjBoardService;
import com.mycompany.myapp.service.ProjTimelineService;



@Controller
public class MainController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProjBoardService projboardService;
    @Autowired
    private ProjTimelineService projTimelineService;
    @Autowired
    private KnowhowService knowhowService;
    @Autowired
    private MembersService membersService;
    @Autowired
    private ProjTimelineDao projTimelineDao;
    @Autowired
    private ProjBoardDao projBoardDao;        
    /* 메인 : 최근 포스트 노출 */
    @RequestMapping("/service/main.do")
    public ModelAndView recentList(){
        List<ProjBoardDto> projList=projboardService.recentList();
        List<KnowhowDto> KhList=knowhowService.recentList();
        ModelAndView mView=new ModelAndView();
        mView.addObject("projList", projList);
        mView.addObject("KhList", KhList);
        mView.setViewName("service/main");
        return mView;
    }
    
    /* *노하우 파트* */
    
    /* 노하우 리스트 */
    @RequestMapping("/service/knowhowList.do")
    public ModelAndView knowhowList(){
        ModelAndView mView = new ModelAndView();
        mView.addObject("list", knowhowService.list());
        mView.setViewName("service/knowhowList");
        return mView;        
    }
    
    /* 노하우 검색 리스트 */
    @RequestMapping("/service/knowhowSearch.do")
    public ModelAndView knowhowSearchList(HttpServletRequest request){
        String tag_name=request.getParameter("tag_name");
        ModelAndView mView = new ModelAndView();
        mView.addObject("list", knowhowService.Searchlist(tag_name));
        mView.setViewName("service/knowhowSearch");
        return mView;        
    }    
    
    /* 노하우 등록 form */
    @RequestMapping("/service/knowhowInsertform.do")
    public ModelAndView knowhowInsertform(){
        List<String> list=new ArrayList<String>();
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", list);
        mView.setViewName("service/knowhowInsertform");
        return mView;
    }
    
    /*    노하우 등록 */ 
    @RequestMapping("/service/knowhowInsert")
    public String knowhowInsert(HttpSession session, HttpServletRequest request, @ModelAttribute KnowhowDto dto){
        String kh_regr_id = (String)session.getAttribute("id");
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        logger.info("파일 경로"+realPath);
        knowhowService.insert(dto, kh_regr_id, realPath);
        return "redirect:/service/knowhowList.do";
    }    
    
    /* 노하우 상세보기 */
    @RequestMapping("/service/knowhowDetail.do")
    public ModelAndView knowhowDetail(HttpServletRequest request, HttpSession session){
        int kh_num=Integer.parseInt(request.getParameter("kh_num"));
        KnowhowDto dtoNum = knowhowService.detail(kh_num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", dtoNum);
        mView.setViewName("service/knowhowDetail");
        return mView;
    }
    
    /* 노하우 파일 다운로드 */
    @RequestMapping("/service/khFileDownload")
    public ModelAndView khdownload(HttpServletRequest request){
        int kh_num=Integer.parseInt(request.getParameter("kh_num"));
        KnowhowDto dtoNum = knowhowService.getFile(kh_num);
        ModelAndView mView=new ModelAndView();
        mView.addObject("dto",dtoNum);
        mView.setViewName("khfileDownView");
        return mView;
    }        
    
    /* 노하우 수정 form */
    @RequestMapping("/service/knowhowUpdateform.do")
    public ModelAndView knowhowUpdateform(HttpServletRequest request){
        int kh_num = Integer.parseInt(request.getParameter("kh_num"));
        KnowhowDto dto=knowhowService.detail(kh_num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", dto);
        mView.setViewName("service/knowhowUpdateform");
        return mView;
    }
    
    /*    노하우 수정 */ 
    @RequestMapping("/service/knowhowUpdate.do")
    public String knowhowUpdate(HttpSession session, HttpServletRequest request,
            @ModelAttribute KnowhowDto dto){
        String kh_modr_id = (String)session.getAttribute("id");
        int kh_num = dto.getKh_num();
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        knowhowService.update(dto, kh_num, kh_modr_id,realPath);
        return "redirect:/service/knowhowDetail.do?kh_num="+kh_num;
    }
    
    /* 노하우 삭제 */
    @RequestMapping("/service/knowhowDelete.do")
    public String knowhowDelete(HttpSession session,HttpServletRequest request) {
        int kh_num = Integer.parseInt(request.getParameter("kh_num"));
        knowhowService.delete(kh_num);
        return "redirect:/service/knowhowList.do";
    }
    
    
    /* *프로젝트 파트* */
    
    /* 프로젝트 등록 form */
    @RequestMapping("/service/projectInsertform.do")
    public ModelAndView ProjectInsertform(){
        List<String> list=new ArrayList<String>();
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", list);
        mView.setViewName("service/projectInsertform");
        return mView;
    }        

    /* 프로젝트 등록 */
    @RequestMapping("/service/projectInsert")
    public String projectInsert(HttpSession session,HttpServletRequest request,
            @ModelAttribute ProjBoardDto dto){
        String proj_regr_id = (String)session.getAttribute("id");
        dto.setProj_regr_id(proj_regr_id);
        dto.setProj_modr_id(proj_regr_id);
        dto.setProj_disp_tf(false);
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        logger.info("파일 경로"+realPath);        
        projboardService.insert(dto, realPath);
        return "redirect:/service/projectBoard.do";
    }

    /* 프로젝트 목록 */
    @RequestMapping("/service/projectBoard")
    public ModelAndView projectList(){
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", projboardService.list());
        mView.setViewName("service/projectBoard");
        return mView;
    }    
    
    /* 프로젝트 수정 form */
    @RequestMapping("/service/projectUpdateform.do")
    public ModelAndView ProjectUpdateform(HttpServletRequest request){
        int proj_num = Integer.parseInt(request.getParameter("num"));
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", projboardService.detail(proj_num));
        mView.setViewName("service/projectUpdateform");
        return mView;
    }        
    
    /* 프로젝트 수정 */
    @RequestMapping("/service/projectUpdate")
    public String projectUpdate(HttpSession session,HttpServletRequest request,
            @ModelAttribute ProjBoardDto dto){
        String proj_modr_id = (String)session.getAttribute("id");
        dto.setProj_modr_id(proj_modr_id);
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        logger.info("프로젝트 수정 파일 경로"+realPath);
        projboardService.update(dto, realPath);
        return "redirect:/service/projectBoard.do";
    }    
    
    /* 프로젝트 삭제 */
    @RequestMapping("/service/projectDelete.do")
    public String projDelete(HttpSession session,HttpServletRequest request) {
        int proj_num = Integer.parseInt(request.getParameter("num"));
        projboardService.delete(proj_num);
        return "redirect:/service/projectBoard.do";
    }        
    
    /* 프로젝트 Timeline 목록 */
    @RequestMapping("/service/projectTimeline.do")
    public ModelAndView projectTimeline(@RequestParam int num, HttpSession session){
        /* 포스트 리스트 가져오기 */
        List<ProjTimelineDto> list = projTimelineDao.getList(num);
        /* 프로젝트 내용 가져오기 */
        ProjBoardDto pdto= projBoardDao.getDetail(num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("list", list);
        mView.addObject("pdto", pdto);        
        mView.setViewName("service/projectTimeline");
        return mView;
    }    
    
    /* 포스트 등록 form */
    @RequestMapping("/service/projPostInsertform.do")
    public ModelAndView PostInsertform(){
        List<String> list=new ArrayList<String>();
        ModelAndView mView=new ModelAndView();
        mView.addObject("list", list);
        mView.setViewName("service/projPostInsertform");
        return mView;
    }

    /*    포스트 등록 */ 
    @RequestMapping("/service/projPostInsert")
    public String postInsert(HttpSession session, HttpServletRequest request,
            @ModelAttribute ProjTimelineDto dto){
        String post_regr_id = (String)session.getAttribute("id");
        int post_proj_num = dto.getPost_proj_num();
        dto.setPost_proj_num(post_proj_num);    
        dto.setPost_regr_id(post_regr_id);
        dto.setPost_modr_id(post_regr_id);
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        logger.info("포스트 등록 파일 경로"+realPath);
        projTimelineService.insert(dto, realPath);
        return "redirect:/service/projectTimeline.do?num="+post_proj_num;
    }
    
    /* 포스트 상세보기 */
    @RequestMapping("/service/projPostDetail.do")
    public ModelAndView projectDetail(HttpServletRequest request, HttpSession session){
        int proj_num = 0;
        int post_num = 0;
        proj_num=Integer.parseInt(request.getParameter("proj_num"));
        post_num=Integer.parseInt(request.getParameter("post_num"));
        ProjTimelineDto dtoNum = new ProjTimelineDto();
        dtoNum.setPost_proj_num(proj_num);
        dtoNum.setPost_num(post_num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", projTimelineService.detail(dtoNum));
        mView.setViewName("service/projPostDetail");
        return mView;
    }
    
    /* 포스트 수정 form */
    @RequestMapping("/service/postUpdateform.do")
    public ModelAndView postUpdateform(HttpServletRequest request){
        int post_num = Integer.parseInt(request.getParameter("post_num"));
        int proj_num = Integer.parseInt(request.getParameter("proj_num"));
        ProjTimelineDto dtoNum = new ProjTimelineDto();
        dtoNum.setPost_num(post_num);
        dtoNum.setPost_proj_num(proj_num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", projTimelineService.detail(dtoNum));
        mView.setViewName("service/projPostUpdateform");
        return mView;
    }
    
    /* 포스트 수정 */ 
    @RequestMapping("/service/postUpdate.do")
    public String postUpdate(HttpSession session, HttpServletRequest request,
            @ModelAttribute ProjTimelineDto dto){
        String post_modr_id = (String)session.getAttribute("id");
        dto.setPost_modr_id(post_modr_id);
        int post_num = dto.getPost_num();
        int post_proj_num = dto.getPost_proj_num();
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        projTimelineService.update(dto, realPath);
        return "redirect:/service/projPostDetail.do?proj_num="+post_proj_num+"&post_num="+post_num;
    }
    
    /* 포스트 삭제 */
    @RequestMapping("/service/postDelete.do")
    public String postDelete(HttpSession session,HttpServletRequest request) {
        int post_num = Integer.parseInt(request.getParameter("post_num"));
        int post_proj_num = Integer.parseInt(request.getParameter("proj_num"));
        ProjTimelineDto dto = new ProjTimelineDto();
        dto.setPost_num(post_num);
        dto.setPost_proj_num(post_proj_num);
        projTimelineService.delete(dto);
        return "redirect:/service/projectTimeline.do?num="+post_proj_num;
    }    

    /* 포스트 파일 다운로드 */
    @RequestMapping("/service/FileDownload")
    public ModelAndView download(HttpServletRequest request){
        int post_proj_num=Integer.parseInt(request.getParameter("proj_num"));
        int post_num=Integer.parseInt(request.getParameter("post_num"));
        ProjTimelineDto dtoNum = new ProjTimelineDto();
        dtoNum.setPost_proj_num(post_proj_num);
        dtoNum.setPost_num(post_num);
        ModelAndView mView=new ModelAndView();
        mView.addObject("dto",projTimelineService.getFile(dtoNum));
        mView.setViewName("fileDownView");
        return mView;
    }    
    
    /*    노하우 Comment 댓글 등록 */ 
    @RequestMapping("/service/KHcommentInsert")
    public String KHComment(HttpSession session, HttpServletRequest request,
            @ModelAttribute KnowhowCommentDto dto){
        String id = (String)session.getAttribute("id");
        dto.setCmt_modr_id(id);
        dto.setCmt_regr_id(id);
        /* 해당 회원 이미지 가져오기 */
        String imgPath = membersService.getPath(dto.getCmt_regr_id());
        dto.setCmt_imgPath(imgPath);    
        knowhowService.cmtInsert(dto);
        return "redirect:/service/knowhowDetail.do?kh_num="+dto.getCmt_kh_num();
    }    
    
    
    /*    Post Comment 댓글 등록 */ 
    @RequestMapping("/service/PostCommentInsert")
    public String PostComment(HttpSession session, HttpServletRequest request,
            @ModelAttribute ProjPostCommentDto dto){
        String id = (String)session.getAttribute("id");
        dto.setCmt_modr_id(id);
        dto.setCmt_regr_id(id);
        /* 해당 회원 이미지 가져오기 */
        String imgPath = membersService.getPath(dto.getCmt_regr_id());
        dto.setCmt_imgPath(imgPath);    
        projTimelineService.cmtInsert(dto);
        return "redirect:/service/projPostDetail.do?proj_num="+dto.getCmt_proj_num()+"&post_num="+dto.getCmt_post_num();
    }        
    
}
