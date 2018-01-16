package com.guoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guoy.service.MainService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private MainService mainServiceImpl;

	
	@RequestMapping("/aaa")
	public String login(){
		System.out.println("============登录1==========");
		return "/index";
	}
	@RequestMapping("/")
	public String logi1n(){
		System.out.println("============登录2==========");
		return "/index";
	}
}
