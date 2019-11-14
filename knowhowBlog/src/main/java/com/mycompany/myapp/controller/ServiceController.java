package com.mycompany.myapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.dao.ProjBoardDao;
import com.mycompany.myapp.dao.ProjTimelineDao;
import com.mycompany.myapp.dto.KnowhowCommentDto;
import com.mycompany.myapp.dto.KnowhowDto;
import com.mycompany.myapp.dto.ProjBoardDto;
import com.mycompany.myapp.dto.ProjPostCommentDto;
import com.mycompany.myapp.dto.ProjTimelineDto;
import com.mycompany.myapp.service.KnowhowService;
import com.mycompany.myapp.service.KnowhowTagService;
import com.mycompany.myapp.service.MembersService;
import com.mycompany.myapp.service.ProjBoardService;
import com.mycompany.myapp.service.ProjPostTagService;
import com.mycompany.myapp.service.ProjTimelineService;



@Controller
public class ServiceController {
    
    /* 의존성을 줄이기 위해 자동으로 와이어링을 해줌 */
    @Autowired
    private ProjBoardService projboardService;
    @Autowired
    private ProjTimelineService projTimelineService;
    @Autowired
    private ProjPostTagService projPostTagService;
    @Autowired
    private KnowhowService knowhowService;
    @Autowired
    private KnowhowTagService knowhowTagService;
    @Autowired
    private MembersService membersService;
    @Autowired
    private ProjTimelineDao projTimelineDao;
    @Autowired
    private ProjBoardDao projBoardDao;        
    /* 메인 : 메인 화면에 최근 포스트들을 노출 시킨다 */
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
        /* autoIncrement 이후에 kh_num을 가져와 넣은 후 Tag 넣는 작업을 한다 */
        knowhowService.insert(dto, kh_regr_id, realPath);
        return "redirect:/service/knowhowList.do";
    }    
    
    /* 노하우 상세보기 */
    @RequestMapping("/service/knowhowDetail.do")
    public ModelAndView knowhowDetail(HttpServletRequest request, HttpSession session){
        int kh_num=Integer.parseInt(request.getParameter("kh_num"));

        dtoNum = knowhowService.detail(dtoNum, kh_num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", dtoNum);
        mView.setViewName("service/knowhowDetail");
        return mView;
    }
    
    /* 노하우 파일 다운로드 */
    @RequestMapping("/service/khFileDownload")
    public ModelAndView khdownload(HttpServletRequest request){
        //다운로드할 파일의 정보를 ModelAndView 객체에 담아서 리턴 받는다.
        int kh_num=Integer.parseInt(request.getParameter("kh_num"));
        KnowhowDto dtoNum = new KnowhowDto();
        dtoNum.setKh_num(kh_num);
        dtoNum = knowhowService.getFile(dtoNum);
        ModelAndView mView=new ModelAndView();
        mView.addObject("dto",dtoNum);
        //파일을 다운로드 시켜줄 view 객체의 이름을 지정하고
        mView.setViewName("khfileDownView");
        //리턴해준다.
        return mView;
    }        
    
    /* 노하우 수정 form */
    @RequestMapping("/service/knowhowUpdateform.do")
    public ModelAndView knowhowUpdateform(HttpServletRequest request){
        int kh_num = Integer.parseInt(request.getParameter("kh_num"));
        KnowhowDto dtoNum = new KnowhowDto();
        dtoNum.setKh_num(kh_num);
        KnowhowDto dto=knowhowService.detail(dtoNum);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", dto);
        mView.setViewName("service/knowhowUpdateform");
        return mView;
    }
    
    /*    노하우 수정 */ 
    @RequestMapping("/service/knowhowUpdate.do")
    public String knowhowUpdate(HttpSession session, HttpServletRequest request,
            @ModelAttribute KnowhowDto dto){
        // 수정한 사람 id 가져와서 modr_id 변경
        String kh_modr_id = (String)session.getAttribute("id");
        dto.setKh_modr_id(kh_modr_id);
        int kh_num = dto.getKh_num();
        
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        //MultipartFile 객체의 참조값 얻어오기
        MultipartFile mFile=dto.getUploadImage();
        //비어있을 경우 공백 넣어준다.
        if( mFile.isEmpty() ) {
            dto.setKh_filePath("");
        }else {
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }            
            dto.setKh_filePath(saveFileName);
            dto.setKh_fileOrgName(orgFileName);
            dto.setKh_fileSize(fileSize);            
        }        
        
        
        try {
            knowhowService.update(dto);
            dto.setKh_num(kh_num);
        }catch(Exception ex){
            
        }finally {
            knowhowTagService.update(dto);
        }
        return "redirect:/service/knowhowDetail.do?kh_num="+kh_num;
    }
    
    /* 노하우 삭제 */
    @RequestMapping("/service/knowhowDelete.do")
    public String knowhowDelete(HttpSession session,HttpServletRequest request) {
        int kh_num = Integer.parseInt(request.getParameter("kh_num"));
        /* kh_disp_tf 를 변경 시킨다 */
        knowhowService.delete(kh_num);
        return "redirect:/service/knowhowList.do";
    }
    
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
        
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        MultipartFile mFile=dto.getUploadImage();
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( mFile.isEmpty() ) {
            dto.setProj_imagePath("");
        }else {
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("사진세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }            
            dto.setProj_imagePath(saveFileName);
        }
        
        projboardService.insert(dto);
        
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
        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( dto.getUploadImage().isEmpty() ) {
            dto.setProj_imagePath("");
        }else {
            MultipartFile mFile=dto.getUploadImage();
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("사진세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }            
            dto.setProj_imagePath(saveFileName);
        }
        
        projboardService.update(dto);
        
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

        //파일을 저장할 폴더의 절대 경로를 얻어온다.
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        MultipartFile mFile=dto.getUploadImage();
        //MultipartFile 객체의 참조값 얻어오기
        //FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
        if( mFile.isEmpty() ) {
            dto.setPost_filePath("");
            
        }else {
            
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            //파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }            
            dto.setPost_filePath(saveFileName);
            dto.setPost_fileOrgName(orgFileName);
            dto.setPost_fileSize(fileSize);            
        }        
        
        /* post가 등록된 두 auto_increment로 등록된 post_num을 가져온다. */
        try {
            int post_num=projTimelineService.insert(dto);
            dto.setPost_num(post_num);
        }catch(Exception ex){
            
        }finally {
            projPostTagService.insert(dto);
        }
        
        return "redirect:/service/projectTimeline.do?num="+post_proj_num;
    }
    
    /* 포스트 상세보기 */
    @RequestMapping("/service/projPostDetail.do")
    public ModelAndView projectDetail(HttpServletRequest request, HttpSession session){
        /* post_num, proj_num 초기화 */
        int proj_num = 0;
        int post_num = 0;
        
        /* 해당 값을 넣어준다. */
        proj_num=Integer.parseInt(request.getParameter("proj_num"));
        post_num=Integer.parseInt(request.getParameter("post_num"));
        
        /* 두 개의 번호를 넣은 뒤 */
        ProjTimelineDto dtoNum = new ProjTimelineDto();
        dtoNum.setPost_proj_num(proj_num);
        dtoNum.setPost_num(post_num);
        /* 전달 및 return  */
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
        MultipartFile mFile=dto.getUploadImage();
        if( mFile.isEmpty() ) {
            dto.setPost_filePath(""); 
        }else {
            //원본 파일명
            String orgFileName=mFile.getOriginalFilename();
            //파일 사이즈
            long fileSize=mFile.getSize();
            //저장할 파일의 상세 경로
            String filePath=realPath+File.separator;
            System.out.println(filePath);
            //디렉토리를 만들 파일 객체 생성
            File file=new File(filePath);
            if(!file.exists()){//디렉토리가 존재하지 않는다면
                file.mkdir();//디렉토리를 만든다.
            }
            String saveFileName=System.currentTimeMillis()+orgFileName;
            System.out.println("세이프파일:"+saveFileName);
            try{
                //upload 폴더에 파일을 저장한다.
                mFile.transferTo(new File(filePath+saveFileName));
            }catch(Exception e){
                e.printStackTrace();
            }            
            dto.setPost_filePath(saveFileName);
            dto.setPost_fileOrgName(orgFileName);
            dto.setPost_fileSize(fileSize);            
        }        
        
        try {
            projTimelineService.update(dto);
            dto.setPost_num(post_num);
            dto.setPost_proj_num(post_proj_num);
        }catch(Exception ex){
            
        }finally {
            projPostTagService.update(dto);
        }

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
        //다운로드할 파일의 정보를 ModelAndView 객체에 담아서 리턴 받는다.
        int post_proj_num=Integer.parseInt(request.getParameter("proj_num"));
        int post_num=Integer.parseInt(request.getParameter("post_num"));
        ProjTimelineDto dtoNum = new ProjTimelineDto();
        dtoNum.setPost_proj_num(post_proj_num);
        dtoNum.setPost_num(post_num);
        //ModelAndView 객체에 담아서 리턴
        ModelAndView mView=new ModelAndView();
        mView.addObject("dto",projTimelineService.getFile(dtoNum));
        //파일을 다운로드 시켜줄 view 객체의 이름을 지정하고
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
