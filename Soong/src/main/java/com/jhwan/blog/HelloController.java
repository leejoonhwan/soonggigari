package com.jhwan.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("name", "joonhwan");
		return mav;
	}
}
