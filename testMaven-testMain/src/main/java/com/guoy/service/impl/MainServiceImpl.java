package com.guoy.service.impl;

import com.guoy.dao.MyBatisDao;
import com.guoy.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author GUOYE
 */
@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MyBatisDao myBatisDao;
	


}