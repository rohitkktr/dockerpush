package com.programcreek.helloworld.controller;
 
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
	
 @RequestMapping("/")
 public String Homepg()
 {
	 return "helloworld";
 }
 
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			
			@RequestParam(value = "fname") String fname,@RequestParam(value = "lname") String lname){
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		
		mv.addObject("fname", fname);
		mv.addObject("lname", lname);
		
		return mv;
	}
}