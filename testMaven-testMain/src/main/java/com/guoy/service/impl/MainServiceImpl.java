package com.guoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guoy.dao.MyBatisDao;
import com.guoy.model.Video;
import com.guoy.service.MainService;


/**
 * @author GUOYE
 */
@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MyBatisDao myBatisDao;
	
	@Override
	public int insertVideo(Video v) {

		return myBatisDao.insert("", v);
	}

}