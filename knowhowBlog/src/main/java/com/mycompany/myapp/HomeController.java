package com.mycompany.myapp;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main 페이지
 */
@Controller
public class HomeController {
	
	@RequestMapping("/home.do")
	public ModelAndView home(){
		List<String> list=new ArrayList<String>();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("home");
		return mView;
	}
	
}
	

