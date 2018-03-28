package com.weknow.wh.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weknow.util.mail.MailUtils;
import com.weknow.util.rabbit.WhUtil;
import com.weknow.wh.model.WeKnowUser;
import com.weknow.wh.service.WeKnowUserServiceI;

@Controller 
public class wh {
	
	@Autowired
	private WeKnowUserServiceI weKnowUserService;
   
	@RequestMapping("/weburlsave")
	@ResponseBody
	public String printWelcome(HttpServletRequest request, HttpServletResponse response) {
		//model.addAttribute("message", "Spring 3 MVC Hello World");
		//response.
		System.out.println("xxd");
		return "hello";
	}
	
	@RequestMapping("/verifyMail")
	@ResponseBody
	public String verifyMail(HttpServletRequest request, HttpServletResponse response) {
		
		String mailUrl = request.getParameter("mailUrl");
		String userName =request.getParameter("userName");
		WhUtil whUtil = new WhUtil();
		String mailCon = whUtil.makeVerify();
		
		MailUtils cn = new MailUtils();
		cn.setAddress("xxd1279@163.com", mailUrl, mailCon);
		cn.setAffix("d:/xd.txt", "xd.txt");
		cn.send("smtp.163.com", "xxd1279@163.com", "xxd1279");
		System.out.println(mailUrl);
		return "";
	}
	
	@RequestMapping("/signUp")
	@ResponseBody
	public String signUp(HttpServletRequest request, HttpServletResponse response) {
		
		String mailUrl = request.getParameter("mailUrl");
		String userName =request.getParameter("userName");
		String userPass = request.getParameter("uPass");
		
		WeKnowUser weUser = new WeKnowUser();
		weUser.setUsermail(mailUrl);
		weUser.setUsername(userName);
		weUser.setUserpassword(userPass);
		weUser.setWkuserid(UUID.randomUUID().toString());
		
		weKnowUserService.insertSelective(weUser);
		String ret = "×¢²á³É¹¦£¡";
		try {
			response.getWriter().write(ret);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "";
	}
	

}
