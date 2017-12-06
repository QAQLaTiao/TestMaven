package com.guoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guoy.service.MainService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GUOYE
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MainService mainServiceImpl;

    @ResponseBody
    @RequestMapping("/nana")
    public String login(String nana) {
        System.out.println("============登录==========");
        return "";

    }
}
