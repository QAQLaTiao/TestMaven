package com.guoy.controller;

import com.guoy.dao.MyBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guoy.service.MainService;

import javax.annotation.Resource;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    private MainService mainServiceImpl;
    @Resource
    MyBatisDao myBatisDao;


    @RequestMapping("/aaa")
    public String login() {
        //ArrayList<RegisterModel> registerModel = JSONObject.parseObject(data, new TypeReference<ArrayList<RegisterModel>>() {
        //});

        return "";
    }

    @RequestMapping("/index")
    public String logi1n() {
        System.out.println("============登录2==========");
        return "/index";
    }
}
