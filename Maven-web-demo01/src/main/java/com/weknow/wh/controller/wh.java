package com.weknow.wh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class wh {
	
   
	@RequestMapping("/weburlsave")
	@ResponseBody
	public String printWelcome(HttpServletRequest request, HttpServletResponse response) {
		//model.addAttribute("message", "Spring 3 MVC Hello World");
		//response.
		System.out.println("xxd");
		return "hello";
	}
	

}
